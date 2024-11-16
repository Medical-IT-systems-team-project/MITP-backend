package MITP.team.backend.domain_KW.Dto;

import lombok.Builder;

@Builder
public record MedicationsDto(String medName, String description, Long dosage) {

}
