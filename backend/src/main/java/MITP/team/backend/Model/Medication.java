package MITP.team.backend.Model;

import MITP.team.backend.Model.Enum.MedicalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "medication")
public class Medication {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String name;

  @Column(name = "start_date", nullable = false)
  private LocalDate startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDate endDate;

  private String dosage;
  private String frequency;
  private String strength;
  private String unit;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_case_id")
  private MedicalCase medicalCase;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_doctor_id")
  private MedicalDoctor medicalDoctor;

  @Enumerated(EnumType.STRING)
  private MedicalStatus status;
}
