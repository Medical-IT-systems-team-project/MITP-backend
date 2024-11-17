package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Model.Dto.MedicalDoctorRequest;
import MITP.team.backend.Model.Dto.MedicalDoctorResponse;
import MITP.team.backend.Model.Dto.RegisterRequestDto;
import MITP.team.backend.Model.Dto.RegisterResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginAndRegisterMapper {
  private final PasswordEncoder passwordEncoder;

  public MedicalDoctorRequest fromRegisterRequestDto(RegisterRequestDto dto) {
    return MedicalDoctorRequest.builder()
        .login(dto.login())
        .password(passwordEncoder.encode(dto.password()))
        .build();
  }

  public RegisterResponseDto fromUserResponseDto(MedicalDoctorResponse dto, String message) {
    return RegisterResponseDto.builder().login(dto.login()).message(message).build();
  }
}
