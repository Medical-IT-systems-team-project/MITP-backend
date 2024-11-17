package MITP.team.backend.Model.Dto;

import MITP.team.backend.Model.Medication;
import MITP.team.backend.Model.Treatment;
import java.util.List;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MedicalDataDto {
  private Long patientId;

  private List<Treatment> treatments;
  private List<Medication> medications;

  public MedicalDataDto(List<Treatment> treatments, List<Medication> medications) {
    this.treatments = treatments;
    this.medications = medications;
  }
}
