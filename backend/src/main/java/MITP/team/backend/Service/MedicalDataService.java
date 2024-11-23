package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.UserNotFoundException;
import MITP.team.backend.Model.Dto.MedicalDataCaseDto;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.TreatmentDto;
import MITP.team.backend.Model.Mapper.MedicalDataCaseMapper;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.PatientRepository;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class MedicalDataService implements IMedicalDataService {

  private final PatientRepository patientRepository;
  private final MedicalCaseRepository medicalCaseDataRepository;
  private final MedicalDataCaseMapper medicalDataCaseMapper;

  @Override
  public MedicalDataCaseDto getMedicalDataByAccessId(String uuid) {
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
                    new UserNotFoundException("Patient with access ID" + uuid + "does not exist"));
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

  @Override
  public void createNewCase(
      @Valid MedicalDataCaseDto medicalDataCaseDto, Authentication authentication) {

    log.info("Adding new case for patient with access ID {}", medicalDataCaseDto.patientId());
    MedicalDoctor authenticatedMedicalDoctor =
        Optional.ofNullable(authentication)
            .map(Authentication::getPrincipal)
            .filter(MedicalDoctor.class::isInstance)
            .map(MedicalDoctor.class::cast)
            .orElseThrow(() -> new SecurityException("Unauthorized access"));

    MedicalDataCaseDto authenticatedMedicalDataCaseDto =
        new MedicalDataCaseDto(
            medicalDataCaseDto.patientId(),
            medicalDataCaseDto.admissionReason(),
            medicalDataCaseDto.admissionDate(),
            medicalDataCaseDto.description(),
            authenticatedMedicalDoctor,
            medicalDataCaseDto.medications(),
            medicalDataCaseDto.treatments());
    medicalCaseDataRepository.save(
        medicalDataCaseMapper.mapToMedicalDataCase(authenticatedMedicalDataCaseDto));
  }
}
