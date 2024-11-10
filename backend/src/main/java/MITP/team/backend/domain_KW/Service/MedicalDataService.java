package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Dto.MedicalDataDto;
import MITP.team.backend.domain_KW.Exceptions.UserNotFoundException;
import MITP.team.backend.domain_KW.Model.Patient;
import MITP.team.backend.domain_KW.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MedicalDataService implements IMedicalDataService {

  private final PatientRepository patientRepository;

  @Override
  public MedicalDataDto getMedicalDataById(String uuid) {
    Patient patient =
        patientRepository
            .findByAccessId(uuid)
            .orElseThrow(
                () ->
                    new UserNotFoundException(
                        "Patient with access ID " + uuid + " does not exist"));

    return new MedicalDataDto(
        patient.getTreatments(), patient.getMedications(), patient.getDrugTreatment());
  }
}
