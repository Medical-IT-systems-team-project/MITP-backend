package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Dto.MedicalDataDto;

public interface IMedicalDataService {
  MedicalDataDto getMedicalDataById(String id);
}
