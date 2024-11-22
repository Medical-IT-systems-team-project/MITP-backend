package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicationsDto;
import jakarta.validation.Valid;

public interface IMedicationService {
    void createNewMedications(@Valid MedicationsDto medicationsDto);
}
