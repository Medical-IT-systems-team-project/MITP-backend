package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.MedicalStatus;
import jakarta.validation.constraints.NotNull;

public record StatusRequestDto(
        @NotNull MedicalStatus status
) {
}
