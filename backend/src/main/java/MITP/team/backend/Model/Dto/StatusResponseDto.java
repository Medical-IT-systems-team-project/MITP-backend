package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record StatusResponseDto(
        String status
) {
}
