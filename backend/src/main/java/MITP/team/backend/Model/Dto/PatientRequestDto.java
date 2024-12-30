package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Enum.Gender;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record PatientRequestDto(
        @NotNull
        @Pattern(regexp = "^[0-9]{11}$", message = "SSN must have 11 digits")
        String socialSecurityNumber,
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotNull
        @Min(value = 0, message = "Age cannot be less than 0") Integer age,
        @NotNull Gender gender,
        @NotBlank String address,
        @NotBlank
        @Pattern(regexp = "^[0-9]{9}$", message = "Wrong phone number format")
        String phoneNumber,
        @NotBlank @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Wrong mail format")
        String email,
        @NotNull @PastOrPresent LocalDate birthDate) {
}
