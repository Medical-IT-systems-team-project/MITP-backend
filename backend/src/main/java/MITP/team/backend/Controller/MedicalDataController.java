package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.DrugTreatmentDto;
import MITP.team.backend.Model.Dto.MedicalDataDto;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.TreatmentDto;
import MITP.team.backend.Service.IMedicalDataService;
import java.util.List;
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

    @GetMapping("/{Id}/drugTreatments")
    public ResponseEntity<List<DrugTreatmentDto>> getDrugTreatmentsByAccessID(@PathVariable String Id) {
        List<DrugTreatmentDto> drugTreatments = medicalDataService.getDrugTreatmentByAccessId(Id);
        return ResponseEntity.ok(drugTreatments);
    }

    @GetMapping("/{Id}/medications")
    public ResponseEntity<List<MedicationsDto>> getMedicationsByAccessID(@PathVariable String Id) {
        List<MedicationsDto> medications = medicalDataService.getMedicationsByAccessId(Id);
        return ResponseEntity.ok(medications);
    }



}