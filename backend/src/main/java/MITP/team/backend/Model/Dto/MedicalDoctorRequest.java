package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record MedicalDoctorRequest(String login, String password) {}
