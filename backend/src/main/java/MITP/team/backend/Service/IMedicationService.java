package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Dto.StatusRequestDto;
import jakarta.validation.Valid;

public interface IMedicationService {
  void createNewMedication(@Valid MedicationRequestDto medicationRequestDto);

  void changeMedicationStatus(Long id, StatusRequestDto statusRequestDto);

}
