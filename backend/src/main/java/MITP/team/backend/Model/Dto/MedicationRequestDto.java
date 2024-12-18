package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public record MedicationRequestDto(
        @NotBlank String name,
        @NotNull @FutureOrPresent LocalDate startDate,
        @NotNull @Future LocalDate endDate,
        @NotBlank String details,
        @NotBlank String dosageForm,
        @NotBlank String strength,
        @NotBlank String unit,
        Long medicalCaseId,
        Long medicalDoctorId) {
}
