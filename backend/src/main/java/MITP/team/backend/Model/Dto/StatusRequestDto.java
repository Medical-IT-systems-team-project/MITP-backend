package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record StatusRequestDto(
        @NotNull String status
) {
}
