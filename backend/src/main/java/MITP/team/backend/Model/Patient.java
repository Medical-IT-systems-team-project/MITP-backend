package MITP.team.backend.Model;

import MITP.team.backend.Model.Enum.PatientStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Builder
@Getter
@Entity
@Table(name = "patient")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class Patient {

  @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
  private String firstName;

  @NotBlank(groups = {CreateValidation.class, UpdateValidation.class})
  private String lastName;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "patient_id", nullable = false)
  private Long id;

  @Enumerated(EnumType.STRING)
  private PatientStatus status;

  @NotNull(groups = UpdateValidation.class)
  @Column(name = "birth_date")
  private LocalDateTime birthDate;

  @NotNull(groups = {CreateValidation.class})
  @Column(nullable = false)
  private Long socialSecurityNumber;

  private int age;

  public interface CreateValidation {}

  private String gender;
  private String accessId;

  public interface UpdateValidation {}

  private String email; // TODO validate REGEX
  private String phoneNumber; // TODO validate REGEX
  private String address;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
  private List<MedicalCase> medicalCaseData;
}
