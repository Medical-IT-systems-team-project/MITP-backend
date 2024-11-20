package MITP.team.backend.Repository;

import MITP.team.backend.Model.MedicalCaseData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCaseDataRepository extends JpaRepository<MedicalCaseData, Long> {}
