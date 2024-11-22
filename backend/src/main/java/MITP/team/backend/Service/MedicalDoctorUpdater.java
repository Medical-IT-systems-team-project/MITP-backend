package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.LoginRequest;
import MITP.team.backend.Model.Dto.LoginResponse;
import MITP.team.backend.Model.Mapper.MedicalDoctorMapper;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO zrobic interfejs
@Log4j2
@Service
@AllArgsConstructor
@Transactional
class MedicalDoctorUpdater {
  private final MedicalDoctorRepository medicalDoctorRepository;
  private final MedicalDoctorMapper medicalDoctorMapper;

  LoginResponse updateByLogin(String login, LoginRequest requestDto) {
    final MedicalDoctor medicalDoctor =
        medicalDoctorRepository
            .findByLogin(login)
            .orElseThrow(() -> new UsernameNotFoundException("User" + login + " not found"));
    log.info("User found: {}", medicalDoctor);
    final MedicalDoctor updated = medicalDoctorMapper.mapToMedicalDoctor(requestDto);

    medicalDoctorRepository.updateLoginAndPasswordById(
        requestDto.login(), requestDto.password(), medicalDoctor.getId());
    log.info("User updated: {}", updated);
    return medicalDoctorMapper.mapToMedicalDoctorResponseDto(updated);
  }
}
