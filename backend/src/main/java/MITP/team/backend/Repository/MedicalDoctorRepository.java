package MITP.team.backend.Repository;

import MITP.team.backend.Model.MedicalDoctor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MedicalDoctorRepository extends JpaRepository<MedicalDoctor, Long> {
  @Query("select u from MedicalDoctor u where u.login = ?1")
  Optional<MedicalDoctor> findByLogin(String login);

  @Transactional
  @Modifying
  @Query("update MedicalDoctor u set u.login = ?1, u.password = ?2 where u.id = ?3")
  void updateLoginAndPasswordById(String login, String password, Long id);

  @Transactional
  @Modifying
  @Query("delete from MedicalDoctor u where u.login = ?1")
  void deleteByLogin(String login);


}