package MITP.team.backend.Config.errorvalidation;

import lombok.Builder;

@Builder
public record DuplicateKeyExceptionDto(
        String message
) {
}
