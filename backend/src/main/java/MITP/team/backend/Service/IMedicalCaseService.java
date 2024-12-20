package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.*;

import java.util.List;
import org.springframework.security.core.Authentication;

public interface IMedicalCaseService {
  List<MedicalCaseResponseDto> getMedicalDataByAccessId(String id);

  List<TreatmentResponseDto> getTreatmentsById(Long id);

  List<MedicationResponseDto> getMedicationsById(Long id);

  void createNewCase(
      MedicalCaseRequestDto medicalDataCaseRequestDto, Authentication authentication);

  void closeCase(Long id);

  List<Object> getIncompleteList(Long id);

}
