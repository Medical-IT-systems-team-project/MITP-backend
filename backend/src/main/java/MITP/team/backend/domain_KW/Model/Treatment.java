package MITP.team.backend.domain_KW.Model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "treatment")
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String treatment;
    private String description;
    private Date date;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
      name = "treatment_patient",
      joinColumns = @JoinColumn(name = "treatment_id"),
      inverseJoinColumns = @JoinColumn(name = "patient_id"))
  private List<Patient> patients;
}
