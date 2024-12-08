package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.MedicalCaseRequestDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import MITP.team.backend.Service.IMedicalCaseService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/medicalCase")
public class MedicalCaseController {

  private final IMedicalCaseService medicalDataService;

  @GetMapping("/{Id}/summary") // PRZETESTOWANY
  public ResponseEntity<List<MedicalCaseResponseDto>> getMedicalDataByAccessID(
      @PathVariable String Id) {
    List<MedicalCaseResponseDto> medicalDataById = medicalDataService.getMedicalDataByAccessId(Id);
    return ResponseEntity.ok(medicalDataById);
  }

  @GetMapping("/{Id}/treatments")
  public ResponseEntity<List<TreatmentRequestDto>> getTreatmentsByAccessID(
      @PathVariable String Id) {
    List<TreatmentRequestDto> treatments = medicalDataService.getTreatmentByAccessId(Id);
    return ResponseEntity.ok(treatments);
  }

  @GetMapping("/{Id}/medications")
  public ResponseEntity<List<MedicationRequestDto>> getMedicationsByAccessID(
      @PathVariable String Id) {
    List<MedicationRequestDto> medications = medicalDataService.getMedicationsByAccessId(Id);
    return ResponseEntity.ok(medications);
  }

  @PostMapping("/newCase") // PRZETESTOWANY
  public ResponseEntity<String> addNewCase(
      @RequestBody MedicalCaseRequestDto medicalDataCaseRequestDto, Authentication authentication) {
    medicalDataService.createNewCase(medicalDataCaseRequestDto, authentication);
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
