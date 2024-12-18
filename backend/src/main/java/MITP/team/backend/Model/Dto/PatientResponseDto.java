package MITP.team.backend.Model.Dto;

import lombok.Builder;

import java.time.LocalDate;


@Builder
public record PatientResponseDto(
        String firstName,
        String lastName,
        LocalDate birthDate,
        String socialSecurityNumber,
        Integer age,
        String gender,
        String accessId,
        String email,
        String phoneNumber,
        String address

) {
}
