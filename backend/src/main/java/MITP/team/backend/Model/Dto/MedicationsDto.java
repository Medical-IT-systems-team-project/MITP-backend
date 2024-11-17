package MITP.team.backend.Model.Dto;

import lombok.Builder;

@Builder
public record MedicationsDto(String medName, String description, Long dosage) {

}
