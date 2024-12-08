package MITP.team.backend.Repository;

import MITP.team.backend.Model.Enum.MedicalCaseStatus;
import MITP.team.backend.Model.MedicalCase;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCaseRepository extends JpaRepository<MedicalCase, Long> {
  List<MedicalCase> getAllMedicalCaseByAttendingDoctorId(Long Id);

  List<MedicalCase> getAllMedicalCaseByAllowedDoctorsId(Long Id);

  List<MedicalCase> getMedicalCaseByPatientIdAndStatus(Long Id, MedicalCaseStatus status);

  List<MedicalCase> getMedicalCaseByPatientId(Long Id);
}
