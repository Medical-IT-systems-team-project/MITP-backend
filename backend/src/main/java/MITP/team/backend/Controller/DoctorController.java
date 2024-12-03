package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.MedicationsDto;
import MITP.team.backend.Model.Dto.TreatmentDto;
import MITP.team.backend.Service.IMedicationService;
import MITP.team.backend.Service.ITreatmentService;
import MITP.team.backend.Service.PatientService;
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
    private final PatientService patientService;

    @PostMapping("/new/Treatment")
    public ResponseEntity<?> createNewTreatment(@Valid @RequestBody TreatmentDto treatmentDto) {
        treatmentService.createNewTreatment(treatmentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("New treatment added");
    }

    @PostMapping("/new/Medications")
    public ResponseEntity<?> createNewMedications(@Valid @RequestBody MedicationsDto medicationsDto) {
        medicationService.createNewMedications(medicationsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("New medications added");
    }

    @GetMapping("/patient/all")
    public ResponseEntity<?> getAllPatients(Authentication auth) {
        return ResponseEntity.ok().body(patientService.getAllPatients(auth));
    }

}
