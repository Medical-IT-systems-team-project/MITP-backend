package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import jakarta.validation.Valid;

public interface ITreatmentService {
  void createNewTreatment(@Valid TreatmentRequestDto treatmentRequestDto);
}
