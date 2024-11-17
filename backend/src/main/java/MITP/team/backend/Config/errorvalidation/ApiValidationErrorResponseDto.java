package MITP.team.backend.Config.errorvalidation;

import java.util.List;
import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ApiValidationErrorResponseDto(
        List<String> errors,
        HttpStatus status
) {
}
