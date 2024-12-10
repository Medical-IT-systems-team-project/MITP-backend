package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.MedicalStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PatientRequestDto(
        @NotNull
        @Pattern(regexp = "^[0-9]{11}$", message = "PESEL musi byc 11 cyfrowy")
        String socialSecurityNumber,
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull Integer age,
        @NotBlank String gender,
        @NotBlank String address,
        @NotBlank
        @Pattern(regexp = "^[0-9]{9}$", message = "Niepoprawny format numeru telefonu")
        String phoneNumber,
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Niepoprawny format email")
        String email,
        @PastOrPresent
        LocalDateTime birthDate) {
}
