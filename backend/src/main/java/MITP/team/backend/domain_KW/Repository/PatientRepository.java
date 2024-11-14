package MITP.team.backend.domain_KW.Repository;

import MITP.team.backend.domain_KW.Model.Medication;
import MITP.team.backend.domain_KW.Model.Patient;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.firstName = ?1 and p.lastName = ?2")
    Optional<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Patient> findByAccessId(String accessId);

  boolean existsByAccessId(String accessId);

  List<Medication> findMedicationsByAccessId(String accessId);
}
