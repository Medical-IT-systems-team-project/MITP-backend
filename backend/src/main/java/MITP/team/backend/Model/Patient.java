package MITP.team.backend.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@Entity
@Table(name = "patient")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "patient_id", nullable = false)
  private Long id;

  private String firstName;
  private String lastName;
  private int age;
  private LocalDateTime birthDate;
  private String gender;
  private String accessId;
  private Long socialSecurityNumber;
  private String email; // TODO validate REGEX
  private String phoneNumber; // TODO validate REGEX
  private String address;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
  private List<MedicalCaseData> medicalCaseData;
}
