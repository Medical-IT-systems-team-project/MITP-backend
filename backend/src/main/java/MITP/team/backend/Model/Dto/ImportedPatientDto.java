package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record ImportedPatientDto(
        String accessId,
        Long doctorId
) {
}
