package MITP.team.backend.domain_KW.Repo;

import MITP.team.backend.domain_KW.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {

}
