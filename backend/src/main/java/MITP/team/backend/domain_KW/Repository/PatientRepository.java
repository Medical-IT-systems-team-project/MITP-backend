package MITP.team.backend.domain_KW.Repository;

import MITP.team.backend.domain_KW.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
