package MITP.team.backend.domain_KW.Repository;

import MITP.team.backend.domain_KW.Model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> findAllByPatientId(Long id);
}
