package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.ImportedPatientDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface IDoctorService {
    Set<MedicalCaseResponseDto> getMedicalCases(Authentication authentication);

    void importPatient(ImportedPatientDto importedPatientDto);
}
