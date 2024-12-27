package MITP.team.backend.Service;

import MITP.team.backend.Exceptions.MedicalCaseNotFoundException;
import MITP.team.backend.Exceptions.PatientNotFoundException;
import MITP.team.backend.Model.Dto.MedicalCaseRequestDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.MedicationResponseDto;
import MITP.team.backend.Model.Dto.TreatmentResponseDto;
import MITP.team.backend.Model.Enum.MedicalCaseStatus;
import MITP.team.backend.Model.Enum.MedicalStatus;
import MITP.team.backend.Model.Mapper.MedicalCaseMapper;
import MITP.team.backend.Model.Mapper.MedicationMapper;
import MITP.team.backend.Model.Mapper.TreatmentMapper;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
@Slf4j
public class MedicalCaseService implements IMedicalCaseService {

  private final PatientRepository patientRepository;
  private final MedicalCaseRepository medicalCaseRepository;
  private final MedicalCaseMapper medicalCaseMapper;
  private final MedicalDoctorRepository medicalDoctorRepository;
  private final TreatmentRepository treatmentRepository;
  private final TreatmentMapper treatmentMapper;
  private final MedicationRepository medicationRepository;
  private final MedicationMapper medicationMapper;

  @Override
  public MedicalCaseResponseDto getCurrentMedicalDataByAccessId(String uuid) {
    Patient patient =
            patientRepository
                    .findByAccessId(uuid)
                    .orElseThrow(
                            PatientNotFoundException::new);

    MedicalCase currentPatientCase =
            medicalCaseRepository.getMedicalCaseByPatientIdAndStatus(patient.getId(), MedicalCaseStatus.ONGOING);

    return medicalCaseMapper.mapToMedicalDataResponseDto(currentPatientCase);
  }

  @Override
  public List<MedicalCaseResponseDto> getAllMedicalDataByAccessId(String uuid) {
    Patient patient =
        patientRepository
            .findByAccessId(uuid)
            .orElseThrow(
                    PatientNotFoundException::new);

    List<MedicalCase> allPatientsCases =
        medicalCaseRepository.getMedicalCaseByPatientId(patient.getId());

    return allPatientsCases.stream().map(medicalCaseMapper::mapToMedicalDataResponseDto).toList();
  }

  @Override
  public List<TreatmentResponseDto> getTreatmentsById(Long Id) {
    MedicalCase currentPatientCase =
            medicalCaseRepository.findById(Id).orElseThrow(MedicalCaseNotFoundException::new);
    return treatmentRepository.getAllTreatmentsByMedicalCase(currentPatientCase).stream()
        .map(treatmentMapper::mapToTreatmentResponseDto)
        .toList();
  }

  @Override
  public List<MedicationResponseDto> getMedicationsById(Long Id) {
    MedicalCase currentPatientCase =
            medicalCaseRepository.findById(Id).orElseThrow(MedicalCaseNotFoundException::new);
    return medicationRepository.getAllMedicationsByMedicalCase(currentPatientCase).stream()
        .map(medicationMapper::mapToMedicationResponseDto)
        .toList();
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
    medicalCaseRepository.save(medicalCaseToSave);
  }

  @Override
  public void closeCase(Long Id) {
    MedicalCase medicalCaseToClose =
            medicalCaseRepository.findById(Id).orElseThrow(MedicalCaseNotFoundException::new);
    medicalCaseToClose.setStatus(MedicalCaseStatus.COMPLETED);
    medicalCaseRepository.save(medicalCaseToClose);
  }

  @Override
  public List<Object> getIncompleteList(Long id) {
    MedicalCase medicalCaseToClose =
            medicalCaseRepository.findById(id).orElseThrow(MedicalCaseNotFoundException::new);

    List<Object> incompleteItems = new ArrayList<>();

    incompleteItems.addAll(
        medicationRepository.getAllMedicationsByMedicalCase(medicalCaseToClose).stream()
            .filter(
                medication ->
                    medication.getStatus() != MedicalStatus.COMPLETED
                        && medication.getStatus() != MedicalStatus.CANCELLED)
            .map(medicationMapper::mapToMedicationResponseDto)
            .toList());

    incompleteItems.addAll(
        treatmentRepository.getAllTreatmentsByMedicalCase(medicalCaseToClose).stream()
            .filter(
                treatment ->
                    treatment.getStatus() != MedicalStatus.COMPLETED
                        && treatment.getStatus() != MedicalStatus.CANCELLED)
            .map(treatmentMapper::mapToTreatmentResponseDto)
            .toList());

    return incompleteItems;
  }


}
