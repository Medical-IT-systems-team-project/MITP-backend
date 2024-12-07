package MITP.team.backend.Repository;

import MITP.team.backend.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository  extends JpaRepository<Medicine, Long> {
}
