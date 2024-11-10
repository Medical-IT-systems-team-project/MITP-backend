package MITP.team.backend.domain_KW.Repository;

import MITP.team.backend.domain_KW.Model.DrugTreatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugTreatmentRepository extends JpaRepository<DrugTreatement, Long> {
  // List<DrugTeratment> findAllById(Long Id);
}
