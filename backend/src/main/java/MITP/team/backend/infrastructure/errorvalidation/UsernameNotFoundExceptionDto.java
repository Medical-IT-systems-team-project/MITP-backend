package MITP.team.backend.infrastructure.errorvalidation;

import lombok.Builder;

@Builder
public record UsernameNotFoundExceptionDto(
        String message
) {
}
