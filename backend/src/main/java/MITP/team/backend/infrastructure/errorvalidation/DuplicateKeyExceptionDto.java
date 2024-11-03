package MITP.team.backend.infrastructure.errorvalidation;

import lombok.Builder;


@Builder
public record DuplicateKeyExceptionDto(
        String message
) {
}
