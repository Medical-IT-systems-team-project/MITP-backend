package MITP.team.backend.Model.Mapper;


import MITP.team.backend.Model.Dto.MedicalDataCaseDto;
import MITP.team.backend.Model.MedicalCaseData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicalDataCaseMapper {
    MedicalCaseData MedicalDataCaseRequestToMedicalDataCase(MedicalDataCaseDto medicalDataCaseDto);
}
