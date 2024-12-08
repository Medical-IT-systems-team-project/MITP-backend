package MITP.team.backend.Model;

import MITP.team.backend.Model.Enum.MedicalStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "medication")
public class Medication {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  private String name;
  private String dosageForm;
  private String strength;
  private String unit;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_case_data_id")
  private MedicalCase medicalCase;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_doctor_id")
  private MedicalDoctor medicalDoctor;

  @Enumerated(EnumType.STRING)
  private MedicalStatus status;
}
