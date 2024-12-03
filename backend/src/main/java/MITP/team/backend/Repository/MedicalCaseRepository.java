package MITP.team.backend.Repository;

import MITP.team.backend.Model.MedicalCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalCaseRepository extends JpaRepository<MedicalCase, Long> {
    List<MedicalCase> getAllMedicalCaseByAttendingDoctorId(Long Id);

    List<MedicalCase> getAllMedicalCaseByAllowedDoctorsId(Long Id);
}
