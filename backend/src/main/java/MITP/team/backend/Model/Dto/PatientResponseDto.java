package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.MedicalStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PatientResponseDto(
        String firstName,
        String lastName,
        LocalDateTime birthDate,
        String socialSecurityNumber,
        Integer age,
        String gender,
        String accessId,
        String email,
        String phoneNumber,
        String address

) {
}
