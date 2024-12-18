package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TreatmentRequestDto(
        @NotBlank String description,
        @NotNull @FutureOrPresent LocalDateTime startDate,
        @NotNull @FutureOrPresent LocalDateTime endDate,
    @NotBlank String name,
        @NotBlank String details,
    Long medicalCaseId,
    Long medicalDoctorId) {}
