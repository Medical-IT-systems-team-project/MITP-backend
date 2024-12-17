package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.StatusRequestDto;
import MITP.team.backend.Model.Dto.StatusResponseDto;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import jakarta.validation.Valid;

public interface ITreatmentService {
    void createNewTreatment(@Valid TreatmentRequestDto treatmentRequestDto);

    void changeTreatmentStatus(Long id, StatusRequestDto statusRequestDto);

}
