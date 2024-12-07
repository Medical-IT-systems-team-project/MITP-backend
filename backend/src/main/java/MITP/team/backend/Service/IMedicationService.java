package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.MedicineRequestDto;
import MITP.team.backend.Model.Dto.MedicineResponseDto;
import jakarta.validation.Valid;

public interface IMedicationService {
    void createNewMedications(@Valid MedicationsDto medicationsDto);


    MedicineResponseDto addMedicine(MedicineRequestDto medicineRequestDto);
}
