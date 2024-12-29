package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.DuplicatedPatientException;
import MITP.team.backend.Exceptions.PatientNotFoundException;
import MITP.team.backend.Model.Dto.EmailRequestDto;
import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import MITP.team.backend.Model.Enum.PatientStatus;
import MITP.team.backend.Model.Mapper.PatientMapper;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import MITP.team.backend.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class PatientService implements IPatientService {
    private final PatientRepository patientRepository;
    private final UniqueIdGenerator idGenerator;
    private final MedicalCaseRepository medicalCaseRepository;
    private final MedicalDoctorRepository medicalDoctorRepository;
    private final PatientMapper patientMapper;
    private final EmailService emailService;

    @Override
    public String createNewPatient(PatientRequestDto patientRequestDto) {
        patientRepository
                .findBySocialSecurityNumber(patientRequestDto.socialSecurityNumber())
                .ifPresent(
                        patient -> {
                            throw new DuplicatedPatientException("Patient already exists");
                        });

        String accessId = idGenerator.generateUniqueId();

        Patient patient = patientMapper.mapToPatient(patientRequestDto);
        patient.setAccessId(accessId);
        patient.setStatus(PatientStatus.IN_HOSPITAL);
        Patient save = patientRepository.save(patient);
        return save.getAccessId();
    }

    @Override
    public PatientResponseDto getPatientByAccessId(String accessId) {
        Patient patient =
                patientRepository.findByAccessId(accessId).orElseThrow(PatientNotFoundException::new);

        return patientMapper.mapToPatientResponseDto(patient);
    }

    @Override
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

    @Override
    public void getNewAccessId(EmailRequestDto emailRequestDto) {
        Patient patient =
                patientRepository
                        .findByEmail(emailRequestDto.email())
                        .orElseThrow(PatientNotFoundException::new);
        String newAccessId = idGenerator.generateUniqueId();
        patient.setAccessId(newAccessId);
        patientRepository.save(patient);
        emailService.sendRestartEmail(emailRequestDto.email(), newAccessId);
    }

    @Override
    public List<PatientResponseDto> getUnassignedPatients() {
        List<Patient> patients = patientRepository.findPatientsWithNoMedicalCaseOrCompletedCases();
        return patients.stream()
                .map(patientMapper::mapToPatientResponseDto)
                .collect(Collectors.toList());
    }
}
