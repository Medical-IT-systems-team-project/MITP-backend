package MITP.team.backend.domain_KW.Dto;

import lombok.Builder;

import java.time.LocalTime;

@Builder
public record DrugTreatmentDto(String drugTreatment, String description, LocalTime startDate, LocalTime endDate) {

}
