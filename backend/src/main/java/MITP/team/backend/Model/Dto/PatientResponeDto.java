package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record PatientResponeDto(
        String firstName,
        String lastName,
        Integer age,
        String gender,
        String accessId
) {
}
