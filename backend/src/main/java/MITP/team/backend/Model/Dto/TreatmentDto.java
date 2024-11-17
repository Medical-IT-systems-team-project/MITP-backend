package MITP.team.backend.Model.Dto;

import java.util.Date;
import lombok.Builder;

@Builder
public record TreatmentDto(
        String treatment,
        String description,
        Date date


) {
}
