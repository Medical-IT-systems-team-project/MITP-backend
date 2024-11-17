package MITP.team.backend.Config.errorvalidation;

import lombok.Builder;

@Builder
public record UsernameNotFoundExceptionDto(
        String message
) {
}
