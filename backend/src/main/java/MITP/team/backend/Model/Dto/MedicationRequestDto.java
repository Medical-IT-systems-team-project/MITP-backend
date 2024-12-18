package MITP.team.backend.Model.Dto;

import lombok.Builder;

import java.time.LocalDate;

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
