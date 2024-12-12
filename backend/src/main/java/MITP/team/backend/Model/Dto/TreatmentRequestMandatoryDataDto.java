package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TreatmentRequestMandatoryDataDto(
        @NotNull String name,
        @NotNull LocalDateTime startDate,
        @NotNull LocalDateTime endDate,
        @NotNull String status
) {}
