package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import MITP.team.backend.Model.Patient;
import MITP.team.backend.Service.IPatientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final IPatientService patientService;

    @PostMapping("/new")
    public String createNewPatient(@RequestBody @Valid PatientRequestDto patientRequestDto) {
        return patientService.createNewPatient(patientRequestDto);
    }

    @GetMapping("/{accessId}")
    public PatientResponseDto getPatientByAccessId(@PathVariable String accessId) {
        return patientService.getPatientByAccessId(accessId);
    }
}
