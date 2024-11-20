package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Medication;
import MITP.team.backend.Model.Treatment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

public record MedicalDataCaseDto(
    @NotNull Long patientId,
    @NotNull String admissionReason,
    @NotNull LocalDateTime admissionDate,
    @NotBlank String description,
    @NotNull MedicalDoctor createdBy,
    List<Medication> medications,
    List<Treatment> treatments) {}
