package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.PatientRequestDto;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface IDoctorService {
    void addPatient(PatientRequestDto patientRequestDto);
    Set<MedicalCaseResponseDto> getMedicalCases(Authentication authentication);
}
