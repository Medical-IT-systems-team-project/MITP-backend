package MITP.team.backend.Controller;

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

  @PatchMapping("/{Id}")
  public ResponseEntity<?> closeCase(@PathVariable Long Id, @RequestParam Boolean force) {
    List<Object> incompleteItems = medicalDataService.getIncompleteList(Id);

    if (!incompleteItems.isEmpty() && !force) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(incompleteItems);
    }
    medicalDataService.closeCase(Id);
    return ResponseEntity.ok("Case closed");
  }
}
