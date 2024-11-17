package MITP.team.backend.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@Entity
@Table(name = "medication")
public class Medication {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @Column(name = "medication_name")
  private String medicationName;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  private String details;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_case_data_id")
  private MedicalCaseData medicalCaseData;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_doctor_id")
  private MedicalDoctor medicalDoctor;
}
