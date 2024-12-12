package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDateTime;

public record MedicalCaseRequestDto(
    @NotNull Long patientId,
    @NotNull String admissionReason,
    @NotNull @PastOrPresent LocalDateTime admissionDate,
    @NotBlank String description,
    @NotNull Long attendingDoctorId) {}
