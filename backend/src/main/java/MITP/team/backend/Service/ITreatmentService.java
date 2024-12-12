package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.StatusRequestDto;
import MITP.team.backend.Model.Dto.StatusResponseDto;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import MITP.team.backend.Model.Dto.TreatmentRequestMandatoryDataDto;
import jakarta.validation.Valid;

public interface ITreatmentService {
    void createNewTreatment(@Valid TreatmentRequestDto treatmentRequestDto);

    StatusResponseDto changeTreatmentStatus(Long id, StatusRequestDto statusRequestDto);

    StatusResponseDto changeTreatmentStatus(TreatmentRequestMandatoryDataDto statusRequestDto);
}
