package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.DrugTreatmentDto;
import MITP.team.backend.Model.Dto.MedicalDataCaseDto;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.TreatmentDto;

import java.util.List;

public interface IMedicalDataService {
    MedicalDataCaseDto getMedicalDataByAccessId(String id);

    List<TreatmentDto> getTreatmentByAccessId(String uuid);

    List<DrugTreatmentDto> getDrugTreatmentByAccessId(String uuid);

    List<MedicationsDto> getMedicationsByAccessId(String id);

    void addNewCase(MedicalDataCaseDto medicalDataCaseDto);
}
