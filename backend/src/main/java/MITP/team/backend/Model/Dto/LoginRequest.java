package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record LoginRequest(String login, String password) {
}