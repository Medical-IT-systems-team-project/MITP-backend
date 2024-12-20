package MITP.team.backend.Model.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EmailRequestDto(
        @NotBlank @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Wrong mail format")
        String email
) {
}
