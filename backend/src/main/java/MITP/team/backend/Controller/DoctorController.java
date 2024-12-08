package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.MedicationRequestDto;
import MITP.team.backend.Model.Dto.TreatmentRequestDto;
import MITP.team.backend.Service.IMedicationService;
import MITP.team.backend.Service.IPatientService;
import MITP.team.backend.Service.ITreatmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/doctor")
public class DoctorController {

  private final ITreatmentService treatmentService;
  private final IMedicationService medicationService;
  private final IPatientService patientService;

  @PostMapping("/new/Treatment")
  public ResponseEntity<?> createNewTreatment(
      @Valid @RequestBody TreatmentRequestDto treatmentRequestDto) {
    treatmentService.createNewTreatment(treatmentRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body("New treatment added");
  }

  @PostMapping("/new/Medications")
  public ResponseEntity<?> createNewMedications(
      @Valid @RequestBody MedicationRequestDto medicationRequestDto) {
    medicationService.createNewMedications(medicationRequestDto);
    return ResponseEntity.status(HttpStatus.CREATED).body("New medications added");
  }

  @GetMapping("/patient/all")
  public ResponseEntity<?> getAllPatients(Authentication auth) {
    return ResponseEntity.ok().body(patientService.getAllPatients(auth));
  }
}
