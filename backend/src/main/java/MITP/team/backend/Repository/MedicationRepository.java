package MITP.team.backend.Repository;

import MITP.team.backend.Model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    //List<Medication> findAllById(Long Id);
}
