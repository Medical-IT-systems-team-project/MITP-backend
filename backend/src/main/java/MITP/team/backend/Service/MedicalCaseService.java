package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.MedicalCaseNotFoundException;
import MITP.team.backend.Exceptions.UserNotFoundException;
import MITP.team.backend.Model.*;
import MITP.team.backend.Model.Dto.MedicalCaseRequestDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import MITP.team.backend.Model.Enum.MedicalCaseStatus;
import MITP.team.backend.Model.Enum.MedicalStatus;
import MITP.team.backend.Model.Mapper.MedicalCaseMapper;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import MITP.team.backend.Repository.PatientRepository;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class MedicalCaseService implements IMedicalCaseService {

  private final PatientRepository patientRepository;
  private final MedicalCaseRepository medicalCaseDataRepository;
  private final MedicalCaseMapper medicalCaseMapper;
  private final MedicalDoctorRepository medicalDoctorRepository;

  @Override
  public List<MedicalCaseResponseDto> getMedicalDataByAccessId(String uuid) {
    Patient patient =
        patientRepository
            .findByAccessId(uuid)
            .orElseThrow(
                () ->
                    new UserNotFoundException(
                        "Patient with access ID " + uuid + " does not exist"));

    List<MedicalCase> allPatientsCases =
        medicalCaseDataRepository.getMedicalCaseByPatientId(patient.getId());

    return allPatientsCases.stream().map(medicalCaseMapper::mapToMedicalDataResponseDto).toList();
  }

  @Override
  public List<TreatmentRequestDto> getTreatmentByAccessId(String uuid) {
    Patient patient =
        patientRepository
            .findByAccessId(uuid)
            .orElseThrow(
                () ->
                    new UserNotFoundException("Patient with access ID" + uuid + "does not exist"));
    return null;
  }

  @Override
  public List<MedicationRequestDto> getMedicationsByAccessId(String uuid) {
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
      @Valid MedicalCaseRequestDto medicalDataCaseRequestDto, Authentication authentication) {

    log.info(
        "Adding new case for patient with access ID {}", medicalDataCaseRequestDto.patientId());
    String username = (String) authentication.getPrincipal();
    MedicalDoctor medicalDoctor =
        medicalDoctorRepository
            .findByLogin(username)
            .orElseThrow(() -> new SecurityException("Unauthorized access"));

    MedicalCase medicalCaseToSave = medicalCaseMapper.mapToMedicalCase(medicalDataCaseRequestDto);
    medicalCaseToSave.setCreatedBy(medicalDoctor);
    medicalCaseToSave.setStatus(MedicalCaseStatus.ONGOING);
    medicalCaseDataRepository.save(medicalCaseToSave);
  }

  @Override
  public void closeCase(Long Id) {
    MedicalCase medicalCaseToClose =
        medicalCaseDataRepository
            .findById(Id)
            .orElseThrow(() -> new MedicalCaseNotFoundException(Id));
    medicalCaseToClose.setStatus(MedicalCaseStatus.COMPLETED);
    medicalCaseDataRepository.save(medicalCaseToClose);
  }

  @Override
  public List<Object> getIncompleteList(Long Id) {
    MedicalCase medicalCaseToClose =
        medicalCaseDataRepository
            .findById(Id)
            .orElseThrow(() -> new MedicalCaseNotFoundException(Id));

    List<Object> incompleteItems = new ArrayList<>();
    for (Medication medication : medicalCaseToClose.getMedications()) {
      if (medication.getStatus() != MedicalStatus.COMPLETED) {
        incompleteItems.add(medication);
      }
    }

    for (Treatment treatment : medicalCaseToClose.getTreatments()) {
      if (treatment.getStatus() != MedicalStatus.COMPLETED) {
        incompleteItems.add(treatment);
      }
    }

    return incompleteItems;
  }
}
