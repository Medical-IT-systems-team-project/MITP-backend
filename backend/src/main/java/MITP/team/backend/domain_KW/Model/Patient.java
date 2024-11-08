package MITP.team.backend.domain_KW.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "patient_medication",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id")
    )
    private List<Medication> medications;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "patient_drug_treatment",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "drug_treatment_id")
    )
    private List<DrugTeratment> drugTreatment;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "patient_treatment",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "treatment_id")
    )
    private List<Treatment> treatments;


}
