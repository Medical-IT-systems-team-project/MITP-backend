package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Model.Patient;
import MITP.team.backend.domain_KW.Repo.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PatientService {
    public final PatientRepo repo;

    public Long generateNewPatientId() {
        Patient patient = repo.save(new Patient());
        return patient.getId();
    }
}
