package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Exceptions.MedicalDoctorNotFoundException;
import MITP.team.backend.Exceptions.PatientNotFoundException;
import MITP.team.backend.Model.Dto.MedicalCaseRequestDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.MedicationResponseDto;
import MITP.team.backend.Model.Dto.TreatmentResponseDto;
import MITP.team.backend.Model.*;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import MITP.team.backend.Repository.PatientRepository;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoArgsConstructor
@Mapper(
    componentModel = "spring",
    uses = {PatientRepository.class, MedicalDoctorRepository.class, MedicationMapper.class})
public abstract class MedicalCaseMapper {

  protected PatientRepository patientRepository;

  protected MedicalDoctorRepository medicalDoctorRepository;

  protected MedicationMapper medicationMapper;

  protected TreatmentMapper treatmentMapper;

  @Autowired
  protected void setPatientRepository(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  @Autowired
  protected void setMedicalDoctorRepository(MedicalDoctorRepository medicalDoctorRepository) {
    this.medicalDoctorRepository = medicalDoctorRepository;
  }

  @Autowired
  protected void setMedicationsMapper(MedicationMapper medicationMapper) {
    this.medicationMapper = medicationMapper;
  }

  @Autowired
  protected void setTreatmentMapper(TreatmentMapper treatmentMapper) {
    this.treatmentMapper = treatmentMapper;
  }

  @Mapping(target = "createdBy", source = "createdBy", qualifiedByName = "mapToCreatedBy")
  @Mapping(
      target = "attendingDoctor",
      source = "attendingDoctor",
      qualifiedByName = "mapToAttendingDoctor")
  @Mapping(target = "medications", source = "medications", qualifiedByName = "mapToMedication")
  @Mapping(target = "treatments", source = "treatments", qualifiedByName = "mapToTreatment")
  @Mapping(target = "patientName", source = "patient", qualifiedByName = "mapToPatientName")
  @Mapping(
      target = "allowedDoctors",
      source = "allowedDoctors",
      qualifiedByName = "mapToAllowedDoctors")
  public abstract MedicalCaseResponseDto mapToMedicalDataResponseDto(MedicalCase medicalCase);

  @Named("mapToCreatedBy")
  protected String mapToCreatedBy(MedicalDoctor medicalDoctor) {
    return medicalDoctor.getFirstName() + " " + medicalDoctor.getLastName();
  }

  @Named("mapToAttendingDoctor")
  protected String mapToAttendingDoctor(MedicalDoctor medicalDoctor) {
    return medicalDoctor.getFirstName() + " " + medicalDoctor.getLastName();
  }

  @Named("mapToAllowedDoctors")
  protected List<String> mapToAllowedDoctors(List<MedicalDoctor> medicalDoctors) {
    return medicalDoctors.stream()
        .map(medicalDoctor -> medicalDoctor.getFirstName() + " " + medicalDoctor.getLastName())
        .toList();
  }

  @Named("mapToMedication")
  protected List<MedicationResponseDto> mapToMedication(List<Medication> medications) {
    return medications.stream().map(medicationMapper::mapToMedicationResponseDto).toList();
  }

  @Named("mapToTreatment")
  protected List<TreatmentResponseDto> mapToTreatment(List<Treatment> treatments) {
    return treatments.stream().map(treatmentMapper::mapToTreatmentResponseDto).toList();
  }

  @Mapping(source = "patientId", target = "patient", qualifiedByName = "mapToPatient")
  @Mapping(
      source = "attendingDoctorId",
      target = "attendingDoctor",
      qualifiedByName = "mapToAttendingDoctor")
  public abstract MedicalCase mapToMedicalCase(MedicalCaseRequestDto medicalDataCaseRequestDto);

  @Named("mapToPatient")
  protected Patient mapToPatient(Long patientId) {
    return patientRepository
        .findById(patientId)
            .orElseThrow(PatientNotFoundException::new);
  }

  @Named("mapToAttendingDoctor")
  protected MedicalDoctor mapToAttendingDoctor(Long attendingDoctorId) {
    return medicalDoctorRepository
        .findById(attendingDoctorId)
        .orElseThrow(
                MedicalDoctorNotFoundException::new);
  }

  @Named("mapToPatientName")
  public String mapToPatientName(Patient patient) {
    return patient.getFirstName() + " " + patient.getLastName();
  }
}
