package MITP.team.backend;

import MITP.team.backend.Config.security.JwtConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(value = JwtConfigProperties.class)
public class MitpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MitpBackendApplication.class, args);
	}

}
