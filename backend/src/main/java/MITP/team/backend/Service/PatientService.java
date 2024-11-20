package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Exceptions.DuplicatedPatientException;
import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// TODO zrobic interfejs
@AllArgsConstructor
@Service
public class PatientService {
  public final PatientRepository repo;
  private final UniqueIdGenerator idGenerator;

  public String createNewPatient(PatientRequestDto patientRequestDto) {
    repo.findByFirstNameAndLastName(patientRequestDto.firstName(), patientRequestDto.lastName())
        .ifPresent(
            patient -> {
              throw new DuplicatedPatientException("Patient already exists");
            });

    String accessId = idGenerator.generateUniqueId();

    Patient patient =
        Patient.builder()
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

}
