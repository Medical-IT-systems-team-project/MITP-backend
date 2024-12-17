package MITP.team.backend.Model.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MedicationRequestDto(
        String name,
        LocalDate startDate,
        LocalDate endDate,
        String details,
        Long medicalCaseId,
        Long medicalDoctorId,
        String dosageForm,
        String strength,
        String unit) {
}
