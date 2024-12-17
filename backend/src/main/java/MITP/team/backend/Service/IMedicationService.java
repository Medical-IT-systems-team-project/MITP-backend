package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Dto.StatusRequestDto;
import MITP.team.backend.Model.Dto.StatusResponseDto;
import jakarta.validation.Valid;

public interface IMedicationService {
  void createNewMedication(@Valid MedicationRequestDto medicationRequestDto);

  StatusResponseDto changeMedicationStatus(Long id, StatusRequestDto statusRequestDto);

}
