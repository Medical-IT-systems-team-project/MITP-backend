package MITP.team.backend.Repository;

import MITP.team.backend.Model.MedicalCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCaseRepository extends JpaRepository<MedicalCase, Long> {}
