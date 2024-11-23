package MITP.team.backend.Model.Mapper;


import MITP.team.backend.Exceptions.MedicalDoctorNotFoundException;
import MITP.team.backend.Model.Dto.TreatmentDto;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Treatment;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@NoArgsConstructor
@AllArgsConstructor
@Mapper(componentModel = "spring")
public abstract class TreatmentMapper {
    private MedicalDoctorRepository medicalDoctorRepository;
  private MedicalCaseRepository medicalCaseDataRepository;

  @Mapping(source = "medicalCaseId", target = "medicalCase", qualifiedByName = "mapToMedicalCase")
  @Mapping(
      source = "medicalDoctorId",
      target = "medicalDoctor",
      qualifiedByName = "mapToMedicalDoctor")
  public abstract Treatment mapToTreatment(TreatmentDto treatmentDto);

    @Named("mapToMedicalDoctor")
    protected MedicalDoctor mapToMedicalDoctor(Long medicalDoctorId) {
        return medicalDoctorRepository
                .findById(medicalDoctorId)
                .orElseThrow(() -> new MedicalDoctorNotFoundException("MedicalDoctor not found with id: " + medicalDoctorId));
    }

  @Named("mapToMedicalCase")
  protected MedicalCase mapToMedicalCaseData(Long medicalCaseDataId) {
        return medicalCaseDataRepository
                .findById(medicalCaseDataId)
                .orElseThrow(() -> new MedicalDoctorNotFoundException("MedicalCaseData not found with id: " + medicalCaseDataId));
    }

}
