package MITP.team.backend.Controller;

import MITP.team.backend.Model.Dto.PatientRequestDto;
import MITP.team.backend.Model.Dto.PatientResponseDto;
import MITP.team.backend.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/new")
    public PatientResponseDto createNewPatient(@RequestBody PatientRequestDto patientRequestDto) {
        String accessId = patientService.createNewPatient(patientRequestDto);
        return PatientResponseDto.builder()
                .accessId(accessId)
                .build();
    }

    @GetMapping("/{accessId}")
    public PatientResponseDto getPatientByAccessId(@PathVariable String accessId) {
        return patientService.getPatientByAccessId(accessId);
    }
}
