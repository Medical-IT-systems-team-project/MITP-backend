package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.MedicalStatus;

import java.time.LocalDateTime;

public record TreatmentResponseDto(
        Long id,
        String name,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String details,
        String medicalDoctorName,
        MedicalStatus status) {
}
