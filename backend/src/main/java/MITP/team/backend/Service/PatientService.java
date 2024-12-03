package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Exceptions.DuplicatedPatientException;
import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

// TODO zrobic interfejs
@AllArgsConstructor
@Service
@Slf4j
public class PatientService {
  public final PatientRepository repo;
  private final UniqueIdGenerator idGenerator;
  public final MedicalCaseRepository medicalCaseRepository;

  public String createNewPatient(PatientRequestDto patientRequestDto) {
    repo.findByFirstNameAndLastName(patientRequestDto.firstName(), patientRequestDto.lastName())
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

    Patient save = repo.save(patient);
    return save.getAccessId();
  }

  public PatientResponseDto getPatientByAccessId(String accessId) {
    Patient patient =
        repo.findByAccessId(accessId)
            .orElseThrow(() -> new DataNotFoundException("Patient not found in system."));

    return PatientResponseDto.builder()
        .firstName(patient.getFirstName())
        .lastName(patient.getLastName())
        .age(patient.getAge())
        .gender(patient.getGender())
        .accessId(patient.getAccessId())
        .build();
  }

  public Set<Patient> getAllPatients(Authentication auth) {
    MedicalDoctor authenticatedMedicalDoctor =
            Optional.ofNullable(auth)
                    .map(Authentication::getPrincipal)
                    .filter(MedicalDoctor.class::isInstance)
                    .map(MedicalDoctor.class::cast)
                    .orElseThrow(() -> new SecurityException("Unauthorized access"));
    log.info("Getting all patients for doctor {}", authenticatedMedicalDoctor.getId());

    Set<Patient> allPatients = new HashSet<>();

    medicalCaseRepository.getAllMedicalCaseByAttendingDoctorId(authenticatedMedicalDoctor.getId())
            .stream()
            .map(MedicalCase::getPatient)
            .forEach(allPatients::add);
    medicalCaseRepository.getAllMedicalCaseByAllowedDoctorsId(authenticatedMedicalDoctor.getId())
            .stream()
            .map(MedicalCase::getPatient)
            .forEach(allPatients::add);
    return allPatients;
  }
}
