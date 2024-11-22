package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.TreatmentDto;
import jakarta.validation.Valid;

public interface ITreatmentService {
    void createNewTreatment(@Valid TreatmentDto treatmentDto);
}
