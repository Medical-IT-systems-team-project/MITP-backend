package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Exceptions.MedicalCaseNotFoundException;
import MITP.team.backend.Exceptions.MedicalDoctorNotFoundException;
import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Dto.MedicationResponseDto;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Medication;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Mapper(
    componentModel = "spring",
    uses = {MedicalDoctorRepository.class, MedicalCaseRepository.class})
public abstract class MedicationMapper {
  protected MedicalDoctorRepository medicalDoctorRepository;
  protected MedicalCaseRepository medicalCaseRepository;

  @Autowired
  protected void setMedicalDoctorRepository(MedicalDoctorRepository medicalDoctorRepository) {
    this.medicalDoctorRepository = medicalDoctorRepository;
  }

  @Autowired
  protected void setMedicalCaseRepository(MedicalCaseRepository medicalCaseRepository) {
    this.medicalCaseRepository = medicalCaseRepository;
  }

  @Mapping(
      source = "medicalDoctor",
      target = "medicalDoctorName",
      qualifiedByName = "mapToMedicalDoctor")
  public abstract MedicationResponseDto mapToMedicationResponseDto(Medication medication);

  @Named("mapToMedicalDoctor")
  protected String mapToMedicalDoctor(MedicalDoctor medicalDoctor) {
    return medicalDoctor.getFirstName() + " " + medicalDoctor.getLastName();
  }

  @Mapping(source = "medicalCaseId", target = "medicalCase", qualifiedByName = "mapToMedicalCase")
  @Mapping(
      source = "medicalDoctorId",
      target = "medicalDoctor",
      qualifiedByName = "mapToMedicalDoctor")
  public abstract Medication mapToMedication(MedicationRequestDto medicationRequestDto);

  @Named("mapToMedicalDoctor")
  protected MedicalDoctor mapToMedicalDoctor(Long medicalDoctorId) {
    return medicalDoctorRepository
        .findById(medicalDoctorId)
        .orElseThrow(
            () ->
                new MedicalDoctorNotFoundException(
                    "MedicalDoctor not found with id: " + medicalDoctorId));
  }

  @Named("mapToMedicalCase")
  protected MedicalCase mapToMedicalCaseData(Long medicalCaseId) {
    return medicalCaseRepository
        .findById(medicalCaseId)
        .orElseThrow(
            () ->
                new MedicalCaseNotFoundException(
                    "MedicalCaseData not found with id: " + medicalCaseId));
  }
}
