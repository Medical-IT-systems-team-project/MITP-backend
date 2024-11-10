package MITP.team.backend.domain_KW.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "medication")
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String medName;
    private String description;
  // TODO czy aby na pewno ten typ ???
  private Long dosage;
}
