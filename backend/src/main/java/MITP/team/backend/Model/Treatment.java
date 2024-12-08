package MITP.team.backend.Model;

import MITP.team.backend.Model.Enum.MedicalStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "treatment")
public class Treatment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  private String name;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date")
  private LocalDateTime endDate;

  private String details;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_case_id")
  private MedicalCase medicalCase;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "medical_doctor_id")
  private MedicalDoctor medicalDoctor;

  @Enumerated(EnumType.STRING)
  private MedicalStatus status;
}
