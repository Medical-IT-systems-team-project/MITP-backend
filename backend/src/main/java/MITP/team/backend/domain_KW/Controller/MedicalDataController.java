package MITP.team.backend.domain_KW.Controller;

import MITP.team.backend.domain_KW.Dto.MedicalDataDto;
import MITP.team.backend.domain_KW.Service.MedicalDataService;
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

    private final MedicalDataService medicalDataService;

    @GetMapping("/all/{patientId}")
    public ResponseEntity<MedicalDataDto> getMedicalDataByID(@PathVariable Long patientId) {
        MedicalDataDto medicalDataById = medicalDataService.getMedicalDataById(patientId);
        return ResponseEntity.ok(medicalDataById);
    }
}
