package MITP.team.backend.Model.Dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PatientResponseDto(
        String firstName,
        String lastName,
        Integer age,
        String gender,
        String accessId,
        LocalDateTime birthDate,
        Long SocialSecurityNumber,
        String email,
        String phoneNumber,
        String address

) {
}
