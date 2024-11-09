package MITP.team.backend.domain_KW.Repository;

import MITP.team.backend.domain_KW.Model.DrugTeratment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugTreatmentRepository extends JpaRepository<DrugTeratment, Long> {
    // List<DrugTeratment> findAllById(Long Id);
}
