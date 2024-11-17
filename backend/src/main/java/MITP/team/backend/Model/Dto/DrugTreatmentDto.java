package MITP.team.backend.Model.Dto;

import java.time.LocalTime;
import lombok.Builder;

@Builder
public record DrugTreatmentDto(String drugTreatment, String description, LocalTime startDate, LocalTime endDate) {

}
