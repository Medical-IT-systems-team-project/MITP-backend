package MITP.team.backend.domain_KW.Dto;


import MITP.team.backend.domain_KW.Model.DrugTeratment;
import MITP.team.backend.domain_KW.Model.Medication;
import MITP.team.backend.domain_KW.Model.Treatment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class MedicalDataDto {
    private Long patientId;

    private List<Treatment> treatments;
    private List<Medication> medications;
    private List<DrugTeratment> drugTeratments;


}
