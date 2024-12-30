package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicalCaseRequestDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.MedicationResponseDto;
import MITP.team.backend.Model.Dto.TreatmentResponseDto;
import MITP.team.backend.Model.MedicalItem;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface IMedicalCaseService {
  List<MedicalCaseResponseDto> getAllMedicalDataByAccessId(String id);

  MedicalCaseResponseDto getCurrentMedicalDataByAccessId(String id);

  List<TreatmentResponseDto> getTreatmentsById(Long id);

  List<MedicationResponseDto> getMedicationsById(Long id);

  void createNewCase(
      MedicalCaseRequestDto medicalDataCaseRequestDto, Authentication authentication);

  void closeCase(Long id);

  List<MedicalItem> getIncompleteList(Long id);

  void changeStatusToCanceled(List<MedicalItem> incompleteItems);

}
