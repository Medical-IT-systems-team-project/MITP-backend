package MITP.team.backend.Model.Mapper;


import MITP.team.backend.Exceptions.MedicalDoctorNotFoundException;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.MedicalCaseData;
import MITP.team.backend.Model.MedicalDoctor;
import MITP.team.backend.Model.Medication;
import MITP.team.backend.Repository.MedicalCaseDataRepository;
import MITP.team.backend.Repository.MedicalDoctorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@NoArgsConstructor
@AllArgsConstructor
@Mapper(componentModel = "spring")
public abstract class MedicationsMapper {
    private MedicalDoctorRepository medicalDoctorRepository;
    private MedicalCaseDataRepository medicalCaseDataRepository;

    @Mapping(source = "medicalCaseDataId", target = "medicalCaseData", qualifiedByName = "mapToMedicalCaseData")
    @Mapping(source = "medicalDoctorId", target = "medicalDoctor", qualifiedByName = "mapToMedicalDoctor")
    public abstract Medication mapToMedication(MedicationsDto medicationsDto);

    @Named("mapToMedicalDoctor")
    protected MedicalDoctor mapToMedicalDoctor(Long medicalDoctorId) {
        return medicalDoctorRepository
                .findById(medicalDoctorId)
                .orElseThrow(() -> new MedicalDoctorNotFoundException("MedicalDoctor not found with id: " + medicalDoctorId));
    }

    @Named("mapToMedicalCaseData")
    protected MedicalCaseData mapToMedicalCaseData(Long medicalCaseDataId) {
        return medicalCaseDataRepository
                .findById(medicalCaseDataId)
                .orElseThrow(() -> new MedicalDoctorNotFoundException("MedicalCaseData not found with id: " + medicalCaseDataId));
    }

}
