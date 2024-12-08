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
        return LoginRequest.builder()
        .login(dto.login())
        .password(passwordEncoder.encode(dto.password()))
        .build();
  }

    public RegisterResponseDto fromUserResponseDto(LoginResponse dto, String message) {
    return RegisterResponseDto.builder().login(dto.login()).message(message).build();
  }
}
