package MITP.team.backend.domain.loginandregister.dto;

import lombok.Builder;

@Builder
public record UserRequestDto(
        String login,
        String password
) {
}
