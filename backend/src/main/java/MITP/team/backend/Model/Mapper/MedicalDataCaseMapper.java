package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Exceptions.PatientNotFoundException;
import MITP.team.backend.Model.Dto.MedicalDataCaseDto;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@NoArgsConstructor
@AllArgsConstructor
@Mapper(componentModel = "spring")
public abstract class MedicalDataCaseMapper {

  private PatientRepository patientRepository;

  @Mapping(source = "patientId", target = "patient", qualifiedByName = "mapToPatient")
  public abstract MedicalCase mapToMedicalDataCase(MedicalDataCaseDto medicalDataCaseDto);

  @Named("mapToPatient")
  protected Patient mapToPatient(Long patientId) {
    return patientRepository
        .findById(patientId)
        .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
  }
  // TODO koniecznie przetestować
}
