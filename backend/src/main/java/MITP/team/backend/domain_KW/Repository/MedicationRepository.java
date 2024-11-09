package MITP.team.backend.domain_KW.Repository;

import MITP.team.backend.domain_KW.Model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    //List<Medication> findAllById(Long Id);
}
