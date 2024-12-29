package MITP.team.backend.Repository;

import MITP.team.backend.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

  Optional<Patient> findByAccessId(String accessId);

  boolean existsByAccessId(String accessId);

  Optional<Patient> findBySocialSecurityNumber(String socialSecurityNumber);

  Optional<Patient> findByEmail(String email);

  @Query("SELECT p FROM Patient p LEFT JOIN p.medicalCase mc WHERE mc IS NULL OR mc.status = 'COMPLETED'")
  List<Patient> findPatientsWithNoMedicalCaseOrCompletedCases();
}
