package MITP.team.backend.Model;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(
    name = "medical_doctor",
    indexes = {@Index(name = "idx_login", columnList = "login")})
public class MedicalDoctor implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "medical_doctor_id", nullable = false)
  private Long id;

  @Column(nullable = false, unique = true)
  private String login;

  @Column(nullable = false)
  private String password;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  private String email; // TODO validate REGEX

  @Column(name = "phone_number")
  private String phoneNumber; // TODO validate REGEX

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "attendingDoctor")
  private List<MedicalCaseData> medicalCaseData;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalDoctor")
  private List<Medication> medications;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalDoctor")
  private List<Treatment> treatments;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public String getUsername() {
    return login;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
