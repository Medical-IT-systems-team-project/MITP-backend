package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import MITP.team.backend.Model.Dto.StatusRequestDto;
import MITP.team.backend.Model.Dto.StatusResponseDto;
import MITP.team.backend.Model.Patient;
import java.util.Set;
import org.springframework.security.core.Authentication;

public interface IPatientService {

  String createNewPatient(PatientRequestDto patientRequestDto);

  PatientResponseDto getPatientByAccessId(String accessId);

  Set<PatientResponseDto> getAllPatients(Authentication auth);

  StatusResponseDto changePatientStatus(Long id, StatusRequestDto status);
}
