package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record MedicineRequestDto(
        String medName,
        String patientFirstName,
        String patientLastName,
        String doctorLastName
) {
}
