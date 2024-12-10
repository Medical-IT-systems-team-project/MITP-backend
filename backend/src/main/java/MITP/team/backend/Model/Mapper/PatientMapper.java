package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import MITP.team.backend.Model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PatientMapper {

  PatientResponseDto mapToPatientResponseDto(Patient patient);

  Patient mapToPatient(PatientRequestDto patientRequestDto);

}
