package MITP.team.backend.Service;

import MITP.team.backend.Component.EmailMessageBuilder;
import MITP.team.backend.Exceptions.MedicalCaseNotFoundException;
import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Repository.MedicalCaseRepository;
import MITP.team.backend.Repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService implements IEmailService {

  private final JavaMailSender emailSender;

  private final MedicalCaseRepository medicalCaseRepository;

  private final EmailMessageBuilder emailMessageBuilder;
  private final PatientRepository patientRepository;

  @Override
  public void sendSummaryEmail(Long id) {

    MedicalCase medicalCaseCloseRequest =
            medicalCaseRepository.findById(id).orElseThrow(MedicalCaseNotFoundException::new);
    emailSender.send(emailMessageBuilder.buildCloseCaseEmail(medicalCaseCloseRequest));
  }

  @Override
  public void sendRestartEmail(String email, String accessId) {
    emailSender.send(emailMessageBuilder.buildRestartEmail(email, accessId));
  }

}
