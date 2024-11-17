package MITP.team.backend.Config.security.dto;

import lombok.Builder;

@Builder
public record JwtResponseDto(
        String login,
        String token
) {
}
