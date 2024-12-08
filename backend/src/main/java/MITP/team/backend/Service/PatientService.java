package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Exceptions.DuplicatedPatientException;
import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import MITP.team.backend.Model.Mapper.PatientMapper;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import MITP.team.backend.Repository.PatientRepository;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class PatientService implements IPatientService {
  private final PatientRepository patientRepository;
  private final UniqueIdGenerator idGenerator;
  private final MedicalCaseRepository medicalCaseRepository;
  private final MedicalDoctorRepository medicalDoctorRepository;
  private final PatientMapper patientMapper;

  public String createNewPatient(PatientRequestDto patientRequestDto) {
    patientRepository
        .findByFirstNameAndLastName(patientRequestDto.firstName(), patientRequestDto.lastName())
        .ifPresent(
            patient -> {
              throw new DuplicatedPatientException("Patient already exists");
            });

    String accessId = idGenerator.generateUniqueId();

    Patient patient =
        Patient.builder()
            .socialSecurityNumber(patientRequestDto.socialSecurityNumber())
            .firstName(patientRequestDto.firstName())
            .lastName(patientRequestDto.lastName())
            .age(patientRequestDto.age())
            .gender(patientRequestDto.gender())
            .accessId(accessId)
            .build();

    Patient save = patientRepository.save(patient);
    return save.getAccessId();
  }

  public PatientResponseDto getPatientByAccessId(String accessId) {
    Patient patient =
        patientRepository
            .findByAccessId(accessId)
            .orElseThrow(() -> new DataNotFoundException("Patient not found in system."));

    return PatientResponseDto.builder()
        .firstName(patient.getFirstName())
        .lastName(patient.getLastName())
        .age(patient.getAge())
        .gender(patient.getGender())
        .accessId(patient.getAccessId())
        .build();
  }

  public Set<PatientResponseDto> getAllPatients(Authentication auth) {
    String username = (String) auth.getPrincipal();
    MedicalDoctor authenticatedMedicalDoctor =
        medicalDoctorRepository
            .findByLogin(username)
            .orElseThrow(() -> new SecurityException("Unauthorized access"));
    log.info("Getting all patients for doctor {}", authenticatedMedicalDoctor.getId());

    Set<PatientResponseDto> allPatients = new HashSet<>();

    medicalCaseRepository
        .getAllMedicalCaseByAttendingDoctorId(authenticatedMedicalDoctor.getId())
        .stream()
        .map(MedicalCase::getPatient)
        .map(patientMapper::mapToPatientResponseDto)
        .forEach(allPatients::add);
    medicalCaseRepository
        .getAllMedicalCaseByAllowedDoctorsId(authenticatedMedicalDoctor.getId())
        .stream()
        .map(MedicalCase::getPatient)
        .map(patientMapper::mapToPatientResponseDto)
        .forEach(allPatients::add);
    return allPatients;
  }
}
