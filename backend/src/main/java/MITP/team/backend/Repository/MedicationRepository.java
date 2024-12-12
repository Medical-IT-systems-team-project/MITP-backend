package MITP.team.backend.Repository;

import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    List<Medication> getAllMedicationsByMedicalCase(MedicalCase medicalCase);


    List<Medication> findAllByNameAndStartDateAndEndDate(String name, LocalDateTime localDateTime, LocalDateTime localDateTime1);

}
