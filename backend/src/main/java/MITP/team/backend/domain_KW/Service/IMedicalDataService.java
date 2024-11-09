package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Dto.MedicalDataDto;

import java.util.Optional;

public interface IMedicalDataService {
    MedicalDataDto getMedicalDataById(Long id);
}
