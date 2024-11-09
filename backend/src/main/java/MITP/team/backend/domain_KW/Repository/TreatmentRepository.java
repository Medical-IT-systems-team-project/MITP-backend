package MITP.team.backend.domain_KW.Repository;

import MITP.team.backend.domain_KW.Model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    //List<Treatment> findAllById(Long Id);
}
