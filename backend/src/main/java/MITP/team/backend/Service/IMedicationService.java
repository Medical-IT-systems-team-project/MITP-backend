package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicationRequestDto;
import jakarta.validation.Valid;

public interface IMedicationService {
  void createNewMedication(@Valid MedicationRequestDto medicationRequestDto);
}
