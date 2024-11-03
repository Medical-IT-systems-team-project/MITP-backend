package MITP.team.backend.infrastructure.loginandregister.controller.dto;

import lombok.Builder;

@Builder
public record RegisterResponseDto(
        String login,
        String message
) {
}
