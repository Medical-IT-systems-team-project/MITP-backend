package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.MedicalCaseRequestDto;
import MITP.team.backend.Model.Dto.MedicalCaseResponseDto;
import MITP.team.backend.Model.Dto.MedicationResponseDto;
import MITP.team.backend.Model.Dto.TreatmentResponseDto;
import MITP.team.backend.Model.MedicalItem;
import MITP.team.backend.Service.EmailService;
import MITP.team.backend.Service.IMedicalCaseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/medical-case")
public class MedicalCaseController {

    private final IMedicalCaseService medicalDataService;
    private final EmailService emailService;

    @GetMapping("/{accessId}/summary")
    public ResponseEntity<MedicalCaseResponseDto> getSummaryMedicalDataByAccessID(
            @PathVariable String accessId) {
        return ResponseEntity.ok(medicalDataService.getCurrentMedicalDataByAccessId(accessId));
    }

    @GetMapping("/{accessId}/history")
    public ResponseEntity<List<MedicalCaseResponseDto>> getHistoryMedicalDataByAccessID(
            @PathVariable String accessId) {
        return ResponseEntity.ok(medicalDataService.getAllMedicalDataByAccessId(accessId));
    }

    @GetMapping("/{Id}/treatment/all")
    public ResponseEntity<List<TreatmentResponseDto>> getTreatmentsById(@PathVariable Long Id) {
        List<TreatmentResponseDto> treatments = medicalDataService.getTreatmentsById(Id);
        return ResponseEntity.ok(treatments);
    }

    @GetMapping("/{Id}/medication/all")
    public ResponseEntity<List<MedicationResponseDto>> getMedicationsById(
            @PathVariable Long Id) {
        List<MedicationResponseDto> medications = medicalDataService.getMedicationsById(Id);
        return ResponseEntity.ok(medications);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addNewCase(
            @Valid @RequestBody MedicalCaseRequestDto medicalDataCaseRequestDto, Authentication authentication) {
        medicalDataService.createNewCase(medicalDataCaseRequestDto, authentication);
        return ResponseEntity.status(HttpStatus.CREATED).body("New case added");
    }

    @PatchMapping("/{Id}")
    public ResponseEntity<?> closeCase(@PathVariable Long Id, @RequestParam(defaultValue = "false") Boolean force) {
        List<MedicalItem> incompleteItems = medicalDataService.getIncompleteList(Id);

        if (!incompleteItems.isEmpty() && !force) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Case has incomplete treatments or medications");
        }
        if (force) {
            medicalDataService.changeStatusToCanceled(incompleteItems);
        }
        medicalDataService.closeCase(Id);
        emailService.sendSummaryEmail(Id);
        return ResponseEntity.ok("Case closed");
    }

    @PatchMapping("/allowed-doctor/{accessId}")
    public ResponseEntity<?> addAllowedDoctor(@PathVariable String accessId, Authentication authentication) {
        medicalDataService.addAllowedDoctor(accessId, authentication);
        return ResponseEntity.ok("Doctor added to allowed");
    }
}
