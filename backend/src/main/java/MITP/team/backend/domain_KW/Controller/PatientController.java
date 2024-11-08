package MITP.team.backend.domain_KW.Controller;

import MITP.team.backend.domain_KW.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;


    @GetMapping("/new")
    public Long generateID() {
        return patientService.generateNewPatientId();
    }

}
