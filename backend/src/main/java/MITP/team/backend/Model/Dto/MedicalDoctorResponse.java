package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record MedicalDoctorResponse(String login, String password) {}
