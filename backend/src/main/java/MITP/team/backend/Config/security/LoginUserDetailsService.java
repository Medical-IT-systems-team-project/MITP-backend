package MITP.team.backend.Config.security;

import MITP.team.backend.Model.Dto.MedicalDoctorResponse;
import MITP.team.backend.Service.LoginAndRegisterService;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {

  private final LoginAndRegisterService loginAndRegisterService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    final MedicalDoctorResponse byUsername = loginAndRegisterService.findByUsername(username);
        return getUser(byUsername);
    }

  private org.springframework.security.core.userdetails.User getUser(MedicalDoctorResponse dto) {
        return new org.springframework.security.core.userdetails.User(
                dto.login(),
                dto.password(),
                Collections.emptyList());
    }
}
