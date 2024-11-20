package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.DrugTreatmentDto;
import MITP.team.backend.Model.Dto.MedicalDataCaseDto;
import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.TreatmentDto;
import MITP.team.backend.Service.IMedicalDataService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/medicalData")
public class MedicalDataController {

  private final IMedicalDataService medicalDataService;

  @GetMapping("/{Id}/summary")
  public ResponseEntity<MedicalDataCaseDto> getMedicalDataByAccessID(@PathVariable String Id) {
    MedicalDataCaseDto medicalDataById = medicalDataService.getMedicalDataByAccessId(Id);
    return ResponseEntity.ok(medicalDataById);
  }

  @GetMapping("/{Id}/treatments")
  public ResponseEntity<List<TreatmentDto>> getTreatmentsByAccessID(@PathVariable String Id) {
    List<TreatmentDto> treatments = medicalDataService.getTreatmentByAccessId(Id);
    return ResponseEntity.ok(treatments);
  }

  @GetMapping("/{Id}/drugTreatments")
  public ResponseEntity<List<DrugTreatmentDto>> getDrugTreatmentsByAccessID(
      @PathVariable String Id) {
    List<DrugTreatmentDto> drugTreatments = medicalDataService.getDrugTreatmentByAccessId(Id);
    return ResponseEntity.ok(drugTreatments);
  }

  @GetMapping("/{Id}/medications")
  public ResponseEntity<List<MedicationsDto>> getMedicationsByAccessID(@PathVariable String Id) {
    List<MedicationsDto> medications = medicalDataService.getMedicationsByAccessId(Id);
    return ResponseEntity.ok(medications);
  }

  @PostMapping("/newCase")
  public ResponseEntity<String> addNewCase(
      @RequestBody MedicalDataCaseDto medicalDataCaseDto, Authentication authentication) {
    medicalDataService.createNewCase(medicalDataCaseDto, authentication);
    return ResponseEntity.status(HttpStatus.CREATED).body("New case added");
  }
}
