package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Dto.DrugTreatmentDto;
import MITP.team.backend.domain_KW.Dto.MedicalDataDto;
import MITP.team.backend.domain_KW.Dto.MedicationsDto;
import MITP.team.backend.domain_KW.Dto.TreatmentDto;

import java.util.List;

public interface IMedicalDataService {
    MedicalDataDto getMedicalDataByAccessId(String id);

    List<TreatmentDto> getTreatmentByAccessId(String uuid);

    List<DrugTreatmentDto> getDrugTreatmentByAccessId(String uuid);

    List<MedicationsDto> getMedicationsByAccessId(String id);
}
