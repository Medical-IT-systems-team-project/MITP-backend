package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Model.Dto.LoginRequest;
import MITP.team.backend.Model.Dto.LoginResponse;
import MITP.team.backend.Model.MedicalDoctor;
import org.springframework.stereotype.Service;

@Service
public class MedicalDoctorMapper {

  public MedicalDoctor mapToMedicalDoctor(LoginRequest medicalDoctorRequest) {
    return MedicalDoctor.builder()
        .login(medicalDoctorRequest.login())
        .password(medicalDoctorRequest.password())
        .build();
  }

  public LoginResponse mapToMedicalDoctorResponseDto(MedicalDoctor medicalDoctor) {
    return LoginResponse.builder()
        .login(medicalDoctor.getLogin())
        .password(medicalDoctor.getPassword())
        .build();
  }


}
