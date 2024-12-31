package MITP.team.backend.Repository;

import MITP.team.backend.Model.Enum.MedicalCaseStatus;
import MITP.team.backend.Model.MedicalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalCaseRepository extends JpaRepository<MedicalCase, Long> {
  List<MedicalCase> getAllMedicalCaseByAttendingDoctorId(Long Id);

  List<MedicalCase> getAllMedicalCaseByAllowedDoctorsId(Long Id);

  MedicalCase getMedicalCaseByPatientIdAndStatus(Long Id, MedicalCaseStatus status);

  List<MedicalCase> getAllMedicalCaseByPatientId(Long Id);
}
