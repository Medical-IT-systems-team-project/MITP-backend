package MITP.team.backend.domain_KW.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "drug_treatment")
public class DrugTeratment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String drugTreatment;
    private Date startDate;
    private Date endDate;
    private String description;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "drug_treatment_medications",
            joinColumns = @JoinColumn(name = "drug_treatment_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id")
    )
    private List<Medication> medications;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "drug_treatment_patients",
//            joinColumns = @JoinColumn(name = "drug_treatment_id"),
//            inverseJoinColumns = @JoinColumn(name = "patient_id")
//    )
//    private List<Patient> patients;


}
