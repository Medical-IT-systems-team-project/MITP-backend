package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.MedicalCaseStatus;
import java.time.LocalDateTime;
import java.util.List;

public record MedicalCaseResponseDto(
    MedicalCaseStatus status,
    String admissionReason,
    LocalDateTime admissionDate,
    String description,
    String createdBy,
    String attendingDoctor,
    List<MedicationResponseDto> medications,
    List<TreatmentResponseDto> treatments,
    List<String> allowedDoctors) {}
