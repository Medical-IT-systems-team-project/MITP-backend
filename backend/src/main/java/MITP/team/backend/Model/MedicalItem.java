package MITP.team.backend.Model;

import MITP.team.backend.Model.Enum.MedicalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public abstract class MedicalItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MedicalStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_case_id")
    private MedicalCase medicalCase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_doctor_id")
    private MedicalDoctor medicalDoctor;
}