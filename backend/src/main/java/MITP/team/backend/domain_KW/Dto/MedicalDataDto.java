package MITP.team.backend.domain_KW.Dto;

import MITP.team.backend.domain_KW.Model.DrugTreatement;
import MITP.team.backend.domain_KW.Model.Medication;
import MITP.team.backend.domain_KW.Model.Treatment;
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
  private List<DrugTreatement> drugTreatments;

  public MedicalDataDto(
      List<Treatment> treatments,
      List<Medication> medications,
      List<DrugTreatement> drugTreatments) {
    this.treatments = treatments;
    this.medications = medications;
    this.drugTreatments = drugTreatments;
  }
}
