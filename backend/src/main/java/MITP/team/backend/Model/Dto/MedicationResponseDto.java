package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.MedicalStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MedicationResponseDto(
    String name,
    LocalDate startDate,
    LocalDate endDate,
    String dosageForm,
    String strength,
    String unit,
    String medicalDoctorName,
    MedicalStatus status) {}
