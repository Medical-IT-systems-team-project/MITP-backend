package MITP.team.backend.Repository;

import MITP.team.backend.Model.Patient;

import java.util.Optional;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("select p from Patient p where p.firstName = ?1 and p.lastName = ?2")
    Optional<Patient> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<Patient> findByAccessId(String accessId);

    boolean existsByAccessId(String accessId);


    Optional<Object> findBySocialSecurityNumber(String socialSecurityNumber);
}
