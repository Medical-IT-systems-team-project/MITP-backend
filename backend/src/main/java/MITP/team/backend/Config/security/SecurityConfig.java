package MITP.team.backend.Config.security;

import MITP.team.backend.Service.LoginAndRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final LoginAndRegisterService loginAndRegisterService;
    private final JwtAuthTokenFilter jwtAuthTokenFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new LoginUserDetailsService(loginAndRegisterService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        //main page
                        .requestMatchers("/", "/index.html").permitAll()
                        //auth
                        .requestMatchers("/login/**").permitAll()
                        .requestMatchers("/register/**").permitAll()
                        //documentation
                        .requestMatchers("/v3/api-docs/**").permitAll()
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/swagger-ui.html").permitAll()
                        //medicalCase
                        .requestMatchers("/medicalCase/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/medicalCase/{Id}/summary").permitAll()
                        .requestMatchers(HttpMethod.GET, "/medicalCase/{Id}/history").permitAll()
                        .requestMatchers(HttpMethod.GET, "/medicalCase/{Id}/treatments").permitAll()
                        .requestMatchers(HttpMethod.GET, "/medicalCase/{Id}/medications").permitAll()
                        //patient
                        .requestMatchers(HttpMethod.POST, "/patient/new").permitAll()
                        .requestMatchers(HttpMethod.GET, "/patient/{accessId}").permitAll()
                        //doctor
                        .requestMatchers(HttpMethod.PATCH, "/doctor/treatment/status").permitAll()
                        .requestMatchers(HttpMethod.PATCH, "/doctor/medication/status").permitAll()
                        //rest
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}
