package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record RegisterResponseDto(
        String login,
        String message
) {
}
