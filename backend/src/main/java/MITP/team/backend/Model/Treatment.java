package MITP.team.backend.Model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Entity
@Table(name = "treatment")
public class Treatment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @Column(name = "treatment_name")
  private String treatmentName;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;

  private String details;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_case_data_id")
  private MedicalCaseData medicalCaseData;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_doctor_id")
  private MedicalDoctor medicalDoctor;
}
