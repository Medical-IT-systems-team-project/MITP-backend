package MITP.team.backend.domain_KW.Dto;

import lombok.Builder;

@Builder
public record PatientRequestDto(
        String firstName,
        String lastName,
        Integer age,
        String gender
) {
}
