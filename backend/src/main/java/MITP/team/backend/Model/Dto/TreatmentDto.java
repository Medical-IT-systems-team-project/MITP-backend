package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TreatmentDto(
        String treatment,
        String description,
        @FutureOrPresent
        LocalDateTime startDate,
        @FutureOrPresent
        LocalDateTime endDate,

        @NotBlank
        String treatmentName,
        String details,
        Long medicalCaseDataId,
        Long medicalDoctorId
) {
}
