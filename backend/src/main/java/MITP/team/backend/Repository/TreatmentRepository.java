package MITP.team.backend.Repository;

import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.Medication;
import MITP.team.backend.Model.Treatment;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
   List<Treatment> getAllTreatmentsByMedicalCase(MedicalCase medicalCase);

    List<Treatment> findAllByNameAndStartDateAndEndDate(String name, LocalDateTime localDateTime, LocalDateTime localDateTime1);

}
