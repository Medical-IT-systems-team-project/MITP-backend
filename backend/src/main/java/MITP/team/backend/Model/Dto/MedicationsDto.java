package MITP.team.backend.Model.Dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record MedicationsDto(String medName,
                             LocalDateTime startDate,
                             LocalDateTime endDate,
                             String details,
                             Long medicalCaseDataId,
                             Long medicalDoctorId

) {

}
