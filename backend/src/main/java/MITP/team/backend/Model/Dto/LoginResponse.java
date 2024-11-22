package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record LoginResponse(String login, String password) {
}
