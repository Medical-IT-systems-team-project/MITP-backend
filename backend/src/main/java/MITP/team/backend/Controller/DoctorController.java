package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.*;
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

    @PostMapping("/new/Medication")
    public ResponseEntity<?> createNewMedication(
            @Valid @RequestBody MedicationRequestDto medicationRequestDto) {
        medicationService.createNewMedication(medicationRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("New medications added");
    }

    @GetMapping("/patient/all")
    public ResponseEntity<?> getAllPatients(Authentication auth) {
        return ResponseEntity.ok().body(patientService.getAllPatients(auth));
    }

    @PatchMapping("/medication/{Id}/changeStatus")
    public ResponseEntity<?> changePatientStatus(@PathVariable Long Id, @RequestBody @Valid StatusRequestDto statusRequestDto) {
        StatusResponseDto statusResponseDto = medicationService.changeMedicationStatus(Id, statusRequestDto);
        return ResponseEntity.ok(statusResponseDto);
    }

    @PatchMapping("/medication/changeStatus")
    public ResponseEntity<?> changePatientStatus(@RequestBody @Valid MedicationRequestMandatoryDataDto statusRequestDto) {
        StatusResponseDto statusResponseDto = medicationService.changeMedicationStatus(statusRequestDto);
        return ResponseEntity.ok(statusResponseDto);
    }
}
