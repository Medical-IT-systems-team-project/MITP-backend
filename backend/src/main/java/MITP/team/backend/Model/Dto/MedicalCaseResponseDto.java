package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.MedicalCaseStatus;

import java.time.LocalDateTime;
import java.util.List;

public record MedicalCaseResponseDto(
        Long id,
        MedicalCaseStatus status,
        String admissionReason,
        LocalDateTime admissionDate,
        String description,
        String createdBy,
        String attendingDoctor,
        String patientName,
        List<MedicationResponseDto> medications,
        List<TreatmentResponseDto> treatments,
        List<String> allowedDoctors) {
}
