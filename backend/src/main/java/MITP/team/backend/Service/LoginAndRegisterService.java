package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicalDoctorRequest;
import MITP.team.backend.Model.Dto.MedicalDoctorResponse;
import MITP.team.backend.Model.Mapper.MedicalDoctorMapper;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

// TODO zrobic interfejs
@Log4j2
@AllArgsConstructor
@Component
public class LoginAndRegisterService {

  private final MedicalDoctorRepository medicalDoctorRepository;
  private final MedicalDoctorMapper medicalDoctorMapper;
  private final MedicalDoctorUpdater medicalDoctorUpdater;

  public MedicalDoctorResponse register(MedicalDoctorRequest requestDto) {
    final MedicalDoctor medicalDoctor = medicalDoctorMapper.mapToMedicalDoctor(requestDto);
    final MedicalDoctor saved = medicalDoctorRepository.save(medicalDoctor);
    return medicalDoctorMapper.mapToMedicalDoctorResponseDto(saved);
  }

  public MedicalDoctorResponse findByUsername(String username) {

    final MedicalDoctor medicalDoctor =
        medicalDoctorRepository
            .findByLogin(username)
            .orElseThrow(() -> new UsernameNotFoundException("User: " + username + " not found"));
    log.info("User found: {}", medicalDoctor);
    return medicalDoctorMapper.mapToMedicalDoctorResponseDto(medicalDoctor);
  }

  public MedicalDoctorResponse updateByLogin(String login, MedicalDoctorRequest requestDto) {
    return medicalDoctorUpdater.updateByLogin(login, requestDto);
  }

  public MedicalDoctorResponse deleteUser(final String login) {
    final MedicalDoctor deleted =
        medicalDoctorRepository
            .findByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("User: " + login + " not found"));
    medicalDoctorRepository.deleteByLogin(deleted.getLogin());
    return medicalDoctorMapper.mapToMedicalDoctorResponseDto(deleted);
  }
}
