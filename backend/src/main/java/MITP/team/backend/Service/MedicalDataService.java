package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.UserNotFoundException;
import MITP.team.backend.Model.Dto.DrugTreatmentDto;
import MITP.team.backend.Model.Dto.MedicalDataDto;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.TreatmentDto;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.PatientRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

// TODO cala klasa xd
@AllArgsConstructor
@Service
public class MedicalDataService implements IMedicalDataService {

  private final PatientRepository patientRepository;

  @Override
  public MedicalDataDto getMedicalDataByAccessId(String uuid) {
    Patient patient =
        patientRepository
            .findByAccessId(uuid)
            .orElseThrow(
                () ->
                    new UserNotFoundException(
                        "Patient with access ID " + uuid + " does not exist"));
    return null;
  }

  @Override
  public List<TreatmentDto> getTreatmentByAccessId(String uuid) {
    Patient patient =
        patientRepository
            .findByAccessId(uuid)
            .orElseThrow(
                () ->
                    new UserNotFoundException("Patient with access ID" + uuid + "does not exsit"));
    return null;
  }

  @Override
  public List<DrugTreatmentDto> getDrugTreatmentByAccessId(String uuid) {
    Patient patient =
        patientRepository
            .findByAccessId(uuid)
            .orElseThrow(
                () ->
                    new UserNotFoundException("Patient with access ID" + uuid + "does not exsit"));
    return null;
  }

  @Override
  public List<MedicationsDto> getMedicationsByAccessId(String uuid) {
    Patient patient =
        patientRepository
            .findByAccessId(uuid)
            .orElseThrow(
                () ->
                    new UserNotFoundException("Patient with access ID" + uuid + "does not exsit"));

    return null;
  }
}
