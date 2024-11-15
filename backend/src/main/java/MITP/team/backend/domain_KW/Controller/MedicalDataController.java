package MITP.team.backend.domain_KW.Controller;

import MITP.team.backend.domain_KW.Dto.MedicalDataDto;
import MITP.team.backend.domain_KW.Dto.TreatmentDto;
import MITP.team.backend.domain_KW.Service.IMedicalDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/medicalData")
public class MedicalDataController {

    private final IMedicalDataService medicalDataService;

    @GetMapping("/{Id}/summary")
    public ResponseEntity<MedicalDataDto> getMedicalDataByAccessID(@PathVariable String Id) {
        MedicalDataDto medicalDataById = medicalDataService.getMedicalDataByAccessId(Id);
        return ResponseEntity.ok(medicalDataById);
    }

    @GetMapping("/{Id}/treatments")
    public ResponseEntity<List<TreatmentDto>> getTreatmentsByAccessID(@PathVariable String Id) {
        List<TreatmentDto> treatments = medicalDataService.getTreatmentByAccessId(Id);
        return ResponseEntity.ok(treatments);
    }

}
