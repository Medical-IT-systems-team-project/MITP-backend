package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record MedicalCaseRequestDto(
    @NotNull Long patientId,
    @NotNull String admissionReason,
    @NotNull @FutureOrPresent LocalDateTime admissionDate,
    @NotBlank String description,
    @NotNull Long attendingDoctorId) {}
