package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record PatientRequestDto(
        String firstName,
        String lastName,
        Integer age,
        String gender
) {
}
