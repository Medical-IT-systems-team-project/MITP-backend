package MITP.team.backend.Model.Dto;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record MedicationsDto(
    String medName,
    LocalDateTime startDate,
    LocalDateTime endDate,
    String details,
    Long medicalCaseId,
    Long medicalDoctorId) {}
