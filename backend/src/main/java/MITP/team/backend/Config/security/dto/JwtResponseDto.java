package MITP.team.backend.Config.security.dto;


public record JwtResponseDto(
        String login,
        String token,
        Long id
) {
}
