package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicalCaseRequestDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import java.util.List;
import org.springframework.security.core.Authentication;

public interface IMedicalCaseService {
  List<MedicalCaseResponseDto> getMedicalDataByAccessId(String id);

  List<TreatmentRequestDto> getTreatmentByAccessId(String uuid);

  List<MedicationRequestDto> getMedicationsByAccessId(String id);

  void createNewCase(
      MedicalCaseRequestDto medicalDataCaseRequestDto, Authentication authentication);

  void closeCase(Long id);

  List<Object> getIncompleteList(Long id);
}
