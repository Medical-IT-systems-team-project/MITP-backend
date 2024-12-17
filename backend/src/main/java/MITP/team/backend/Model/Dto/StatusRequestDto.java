package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.MedicalStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record StatusRequestDto(
        @NotNull MedicalStatus status
) {
}
