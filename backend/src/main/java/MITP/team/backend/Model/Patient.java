package MITP.team.backend.Model;

import MITP.team.backend.Model.Enum.PatientStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
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
  @Column(name = "id")
  private Long id;

  @Enumerated(EnumType.STRING)
  private PatientStatus status;

  @Column(name = "birth_date")
  @PastOrPresent
  private LocalDate birthDate;

  @Column(nullable = false, unique = true)
  private String socialSecurityNumber;

  private Integer age;

  public interface CreateValidation {}

  private String gender;
  private String accessId;

  public interface UpdateValidation {}

  private String email;
  private String phoneNumber;
  private String address;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
  private List<MedicalCase> medicalCase;
}
