package MITP.team.backend.Model;

import MITP.team.backend.Model.Enum.MedicalCaseStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

// TODO: zawracanie DTO posortowane po dacie (medication & treatment) najlpiej przechowywac juz
// postortowane po prostu
@Getter
@Setter
@Entity
@Table(name = "medical_case")
public class MedicalCase {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "medical_case_id", nullable = false)
  private Long id;

  @Enumerated(EnumType.STRING)
  private MedicalCaseStatus status;

  @Column(name = "admission_reason")
  private String admissionReason;

  @Column(name = "admission_date")
  private LocalDateTime admissionDate;

  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "created_by_doctor_id")
  private MedicalDoctor createdBy;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "attending_doctor_id")
  private MedicalDoctor attendingDoctor;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "patient_id")
  private Patient patient;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalCase", cascade = CascadeType.ALL)
  private List<Medication> medications;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalCase", cascade = CascadeType.ALL)
  private List<Treatment> treatments;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "medical_case_allowed_doctors",
      joinColumns = @JoinColumn(name = "medical_case_id"),
      inverseJoinColumns = @JoinColumn(name = "medical_doctor_id"))
  private List<MedicalDoctor> allowedDoctors;
}
