package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Dto.PatientRequestDto;
import MITP.team.backend.domain_KW.Dto.PatientResponeDto;
import MITP.team.backend.domain_KW.Exceptions.DataNotFoundException;
import MITP.team.backend.domain_KW.Exceptions.DuplicatedPatientException;
import MITP.team.backend.domain_KW.Model.Patient;
import MITP.team.backend.domain_KW.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PatientService {
    public final PatientRepository repo;

    public String createNewPatient(PatientRequestDto patientRequestDto) {

        repo.findByFirstNameAndLastName(patientRequestDto.firstName(), patientRequestDto.lastName())
                .ifPresent(patient -> {
                    throw new DuplicatedPatientException("Patient already exists");
                });

        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(Character::isLetterOrDigit)
                .build();

        String accessId = generator.generate(10);

        Patient patient = Patient.builder()
                .firstName(patientRequestDto.firstName())
                .lastName(patientRequestDto.lastName())
                .age(patientRequestDto.age())
                .gender(patientRequestDto.gender())
                .accessId(accessId)
                .build();

        Patient save = repo.save(patient);

        return save.getAccessId();
    }

    public PatientResponeDto getPatientByAccessId(String accessId) {
        Patient patient = repo.findByAccessId(accessId)
                .orElseThrow(() -> new DataNotFoundException("Patient not found in system."));

        return PatientResponeDto.builder()
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .age(patient.getAge())
                .gender(patient.getGender())
                .accessId(patient.getAccessId())
                .build();
    }
}
