package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.EmailRequestDto;
import MITP.team.backend.Model.Dto.EmailResponseDto;
import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import org.springframework.security.core.Authentication;

import java.util.Set;

public interface IPatientService {

    String createNewPatient(PatientRequestDto patientRequestDto);

    PatientResponseDto getPatientByAccessId(String accessId);

    Set<PatientResponseDto> getAllPatients(Authentication auth);

    EmailResponseDto getNewAccessId(EmailRequestDto email);
}
