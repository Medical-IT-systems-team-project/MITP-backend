package MITP.team.backend.Model.Dto;

import java.time.LocalDate;


public record PatientResponseDto(
        Long id,
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
