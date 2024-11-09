package MITP.team.backend.domain_KW.Controller;

import MITP.team.backend.domain_KW.Dto.PatientRequestDto;
import MITP.team.backend.domain_KW.Dto.PatientResponeDto;
import MITP.team.backend.domain_KW.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/new")
    public PatientResponeDto createNewPatient(@RequestBody PatientRequestDto patientRequestDto) {
        String accessId = patientService.createNewPatient(patientRequestDto);
        return PatientResponeDto.builder()
                .accessId(accessId)
                .build();
    }

    @GetMapping("/{accessId}")
    public PatientResponeDto createNewPatient(@PathVariable String accessId) {
        return patientService.getPatientByAccessId(accessId);
    }
}
