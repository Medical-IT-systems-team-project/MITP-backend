package MITP.team.backend.Model.Mapper;

import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Patient;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient PatientRequesToPatient(PatientRequestDto patientRequestDto);
}

//@Mapping z czego na co source  target