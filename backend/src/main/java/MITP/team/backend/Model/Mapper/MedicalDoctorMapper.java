package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Model.Dto.MedicalDoctorRequest;
import MITP.team.backend.Model.Dto.MedicalDoctorResponse;
import MITP.team.backend.Model.MedicalDoctor;
import org.springframework.stereotype.Service;

@Service
public class MedicalDoctorMapper {

  public MedicalDoctor mapToMedicalDoctor(MedicalDoctorRequest medicalDoctorRequest) {
    return MedicalDoctor.builder()
        .login(medicalDoctorRequest.login())
        .password(medicalDoctorRequest.password())
        .build();
  }

  public MedicalDoctorResponse mapToMedicalDoctorResponseDto(MedicalDoctor medicalDoctor) {
    return MedicalDoctorResponse.builder()
        .login(medicalDoctor.getLogin())
        .password(medicalDoctor.getPassword())
        .build();
  }
}
