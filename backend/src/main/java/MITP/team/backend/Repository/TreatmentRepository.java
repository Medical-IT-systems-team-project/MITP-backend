package MITP.team.backend.Repository;

import MITP.team.backend.Model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
  // List<Treatment> findAllById(Long Id);
}
