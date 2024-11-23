package MITP.team.backend.Service;

import MITP.team.backend.Model.Dto.MedicalDataCaseDto;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.TreatmentDto;
import java.util.List;
import org.springframework.security.core.Authentication;

public interface IMedicalDataService {
    MedicalDataCaseDto getMedicalDataByAccessId(String id);

    List<TreatmentDto> getTreatmentByAccessId(String uuid);

    List<MedicationsDto> getMedicationsByAccessId(String id);

  void createNewCase(MedicalDataCaseDto medicalDataCaseDto, Authentication authentication);
}
