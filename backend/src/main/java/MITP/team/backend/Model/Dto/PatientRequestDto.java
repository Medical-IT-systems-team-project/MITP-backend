package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record PatientRequestDto(
    @NotNull Long socialSecurityNumber,
    @NotNull String firstName,
    @NotNull String lastName,
    Integer age,
    String gender) {}
