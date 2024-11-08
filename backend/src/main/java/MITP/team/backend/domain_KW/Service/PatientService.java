package MITP.team.backend.domain_KW.Service;

import MITP.team.backend.domain_KW.Model.Patient;
import MITP.team.backend.domain_KW.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PatientService {
    public final PatientRepository repo;

    public Long generateNewPatientId() {
        Patient patient = repo.save(new Patient());
        return patient.getId();
    }
}
