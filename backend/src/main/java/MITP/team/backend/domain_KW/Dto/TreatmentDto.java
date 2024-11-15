package MITP.team.backend.domain_KW.Dto;

import lombok.Builder;

import java.util.Date;


@Builder
public record TreatmentDto(
        String treatment,
        String description,
        Date date


) {
}
