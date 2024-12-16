package MITP.team.backend.Model.Dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;

@Builder
public record MedicationRequestDto(
        String name,
        //@PastOrPresent
        LocalDateTime startDate,
        //@PastOrPresent
        LocalDateTime endDate,
        String details,
        Long medicalCaseId,
        Long medicalDoctorId,
        String dosageForm,
        String strength,
        String unit) {
}
