package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Exceptions.MedicalDoctorNotFoundException;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import MITP.team.backend.Model.Dto.TreatmentResponseDto;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Treatment;
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
public abstract class TreatmentMapper {

  protected MedicalDoctorRepository medicalDoctorRepository;
  protected MedicalCaseRepository medicalCaseDataRepository;

  @Autowired
  protected void setMedicalDoctorRepository(MedicalDoctorRepository medicalDoctorRepository) {
    this.medicalDoctorRepository = medicalDoctorRepository;
  }

  @Autowired
  protected void setMedicalCaseDataRepository(MedicalCaseRepository medicalCaseDataRepository) {
    this.medicalCaseDataRepository = medicalCaseDataRepository;
  }

  @Mapping(
      source = "medicalDoctor",
      target = "medicalDoctorName",
      qualifiedByName = "mapToMedicalDoctorName")
  public abstract TreatmentResponseDto mapToTreatmentResponseDto(Treatment treatment);

  @Named("mapToMedicalDoctorName")
  protected String mapToMedicalDoctorName(MedicalDoctor medicalDoctor) {
    return medicalDoctor.getFirstName() + " " + medicalDoctor.getLastName();
  }

  @Mapping(source = "medicalCaseId", target = "medicalCase", qualifiedByName = "mapToMedicalCase")
  @Mapping(
      source = "medicalDoctorId",
      target = "medicalDoctor",
      qualifiedByName = "mapToMedicalDoctor")
  public abstract Treatment mapToTreatment(TreatmentRequestDto treatmentRequestDto);

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
  protected MedicalCase mapToMedicalCaseData(Long medicalCaseDataId) {
    return medicalCaseDataRepository
        .findById(medicalCaseDataId)
        .orElseThrow(
            () ->
                new MedicalDoctorNotFoundException(
                    "MedicalCaseData not found with id: " + medicalCaseDataId));
  }
}
