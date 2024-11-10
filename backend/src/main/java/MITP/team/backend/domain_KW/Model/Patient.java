package MITP.team.backend.domain_KW.Model;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@Entity
@Table(name = "patient")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;
  private int age;
  private String gender;
  private String accessId;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "patient_medication", joinColumns = @JoinColumn(name = "patient_id"))
  private List<Medication> medications;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "patient_drug_treatment", joinColumns = @JoinColumn(name = "patient_id"))
  private List<DrugTreatement> drugTreatment;

  @OneToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "patient_treatment", joinColumns = @JoinColumn(name = "patient_id"))
  private List<Treatment> treatments;
}
