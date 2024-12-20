package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Mapper.MedicalCaseMapper;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DoctorService implements IDoctorService {

    private final MedicalCaseRepository medicalCaseRepository;
    private final MedicalCaseMapper medicalCaseMapper;
    private final MedicalDoctorRepository doctorRepository;


    @Override
    public void addPatient(PatientRequestDto patientRequestDto) {

    }

    @Override
    public Set<MedicalCaseResponseDto> getMedicalCases(Authentication auth) {
        String username = (String) auth.getPrincipal();
        MedicalDoctor medicalDoctor =
                doctorRepository
                        .findByLogin(username)
                        .orElseThrow(() -> new SecurityException("Unauthorized access"));
        Set<MedicalCase> attendingDoctorCases = new HashSet<>(medicalCaseRepository.getAllMedicalCaseByAttendingDoctorId(medicalDoctor.getId()));
        Set<MedicalCase> allowedDoctorCases = new HashSet<>(medicalCaseRepository.getAllMedicalCaseByAllowedDoctorsId(medicalDoctor.getId()));
        attendingDoctorCases.addAll(allowedDoctorCases);
        return attendingDoctorCases.stream()
                .map(medicalCaseMapper::mapToMedicalDataResponseDto)
                .collect(Collectors.toSet());
    }
}
