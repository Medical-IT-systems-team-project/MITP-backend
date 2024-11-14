package MITP.team.backend.domain_KW.Controller;

import MITP.team.backend.domain_KW.Dto.MedicalDataDto;
import MITP.team.backend.domain_KW.Service.IMedicalDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/medicalData")
public class MedicalDataController {

  private final IMedicalDataService medicalDataService;

  @GetMapping("/{id}/summary")
  public ResponseEntity<MedicalDataDto> getMedicalDataByAccessID(@PathVariable String id) {
    MedicalDataDto medicalDataById = medicalDataService.getMedicalDataById(id);
        return ResponseEntity.ok(medicalDataById);
    }
}
