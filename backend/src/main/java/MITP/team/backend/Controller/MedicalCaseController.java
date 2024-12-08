package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.*;
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

  @GetMapping("/{Id}/summary")
  public ResponseEntity<List<MedicalCaseResponseDto>> getMedicalDataByAccessID(
      @PathVariable String Id) {
    List<MedicalCaseResponseDto> medicalDataById = medicalDataService.getMedicalDataByAccessId(Id);
    return ResponseEntity.ok(medicalDataById);
  }

  @GetMapping("/{Id}/treatments")
  public ResponseEntity<List<TreatmentResponseDto>> getTreatmentsByAccessID(@PathVariable Long Id) {
    List<TreatmentResponseDto> treatments = medicalDataService.getTreatmentsById(Id);
    return ResponseEntity.ok(treatments);
  }

  @GetMapping("/{Id}/medications")
  public ResponseEntity<List<MedicationResponseDto>> getMedicationsByAccessID(
      @PathVariable Long Id) {
    List<MedicationResponseDto> medications = medicalDataService.getMedicationsById(Id);
    return ResponseEntity.ok(medications);
  }

  @PostMapping("/newCase")
  public ResponseEntity<String> addNewCase(
      @RequestBody MedicalCaseRequestDto medicalDataCaseRequestDto, Authentication authentication) {
    medicalDataService.createNewCase(medicalDataCaseRequestDto, authentication);
    return ResponseEntity.status(HttpStatus.CREATED).body("New case added");
  }

  @PatchMapping("/{Id}") // TODO test this endpoint
  public ResponseEntity<?> closeCase(@PathVariable Long Id, @RequestParam Boolean force) {
    List<Object> incompleteItems = medicalDataService.getIncompleteList(Id);

    if (!incompleteItems.isEmpty() && !force) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(incompleteItems);
    }
    medicalDataService.closeCase(Id);
    return ResponseEntity.ok("Case closed");
  }
}
