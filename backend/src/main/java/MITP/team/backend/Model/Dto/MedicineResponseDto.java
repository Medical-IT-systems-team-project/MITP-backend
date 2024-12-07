package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record MedicineResponseDto(
        String medName,
        String patientLastName,
        String doctorLastName,
        String dosageDate
) {
}
