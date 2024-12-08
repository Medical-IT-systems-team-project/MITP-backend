package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record TreatmentRequestDto(
    String description,
    @FutureOrPresent LocalDateTime startDate,
    @FutureOrPresent LocalDateTime endDate,
    @NotBlank String name,
    String details,
    Long medicalCaseId,
    Long medicalDoctorId) {}
