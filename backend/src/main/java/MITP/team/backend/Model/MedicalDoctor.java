package MITP.team.backend.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@Table(
        name = "medical_doctor",
        indexes = {@Index(name = "idx_login", columnList = "login")})
public class MedicalDoctor implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_doctor_id", nullable = false)
    private Long id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String login;

    @NonNull
    @Column(nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attendingDoctor")
    private List<MedicalCase> medicalCaseData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private List<MedicalCase> createdMedicalCaseData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalDoctor")
    private List<Medication> medications;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalDoctor")
    private List<Treatment> treatments;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "allowedDoctors")
    private List<MedicalCase> allowedMedicalCases;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public @NonNull String getPassword() {
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
