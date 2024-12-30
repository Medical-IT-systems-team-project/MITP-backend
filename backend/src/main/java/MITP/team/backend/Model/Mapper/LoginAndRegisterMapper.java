package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Model.Dto.LoginRequest;
import MITP.team.backend.Model.Dto.LoginResponse;
import MITP.team.backend.Model.Dto.RegisterRequestDto;
import MITP.team.backend.Model.Dto.RegisterResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginAndRegisterMapper {
  private final PasswordEncoder passwordEncoder;

    public LoginRequest fromRegisterRequestDto(RegisterRequestDto dto) {
      return new LoginRequest(dto.login(), passwordEncoder.encode(dto.password()));
  }

    public RegisterResponseDto fromUserResponseDto(LoginResponse dto, String message) {
      return new RegisterResponseDto(dto.login(), message);
  }
}
