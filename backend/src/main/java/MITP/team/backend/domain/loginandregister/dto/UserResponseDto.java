package MITP.team.backend.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserResponseDto(
        String login,
        String password
) {
}
