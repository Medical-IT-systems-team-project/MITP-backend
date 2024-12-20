package MITP.team.backend.Component;

import MITP.team.backend.Model.MedicalCase;
import MITP.team.backend.Model.Medication;
import MITP.team.backend.Model.Treatment;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailMessageBuilder {

  @Value("${spring.mail.username}")
  private String mailAddress;

  public SimpleMailMessage buildCloseCaseEmail(MedicalCase medicalCaseCloseRequest) {

    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(mailAddress);
    message.setTo(medicalCaseCloseRequest.getPatient().getEmail());
    message.setSubject(createSubject(medicalCaseCloseRequest));
    message.setText(createContent(medicalCaseCloseRequest));

    return message;
  }
  //resetowanie hasła
  public SimpleMailMessage buildRestartEmail(String email, String accessId) {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(mailAddress);
    message.setTo(email);
    message.setSubject("New AccessId");
    message.setText("Your new accessId is: " + accessId);

    return message;
  }

  private String createSubject(MedicalCase medicalCaseCloseRequest) {
    return String.format(
        "Summary of medical case id: %s by %s",
        medicalCaseCloseRequest.getId(), medicalCaseCloseRequest.getCreatedBy().getUsername());
  }

  private String createContent(MedicalCase medicalCaseCloseRequest) {
    StringBuilder content = new StringBuilder();

    // Header
    content
        .append("Dear ")
        .append(medicalCaseCloseRequest.getPatient().getFirstName())
        .append(" ")
        .append(medicalCaseCloseRequest.getPatient().getLastName())
        .append(",\n\n");

    // Basic info
    content.append("This is a summary of your hospital visit:\n\n");
    content
        .append("Admission Date: ")
        .append(
            medicalCaseCloseRequest
                .getAdmissionDate()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
        .append("\n");
    content
        .append("Reason for Admission: ")
        .append(medicalCaseCloseRequest.getAdmissionReason())
        .append("\n\n");

    // Doctors info
    content.append("Medical Staff:\n");
    content
        .append("Creating Doctor: Dr. ")
        .append(medicalCaseCloseRequest.getCreatedBy().getFirstName())
        .append(" ")
        .append(medicalCaseCloseRequest.getCreatedBy().getLastName())
        .append("\n");
    content
        .append("Attending Doctor: Dr. ")
        .append(medicalCaseCloseRequest.getAttendingDoctor().getFirstName())
        .append(" ")
        .append(medicalCaseCloseRequest.getAttendingDoctor().getLastName())
        .append("\n\n");

    // Description
    content
        .append("Case Description:\n")
        .append(medicalCaseCloseRequest.getDescription())
        .append("\n\n");

    // Medications
    if (!medicalCaseCloseRequest.getMedications().isEmpty()) {
      content.append("Prescribed Medications:\n");
      for (Medication medication : medicalCaseCloseRequest.getMedications()) {
        content
            .append("- ")
            .append(medication.getName())
            .append(" (")
            .append(medication.getDosageForm())
            .append(", ")
            .append(medication.getStrength())
            .append(" ")
            .append(medication.getUnit())
            .append(")\n");
      }
      content.append("\n");
    }

    // Treatments
    if (!medicalCaseCloseRequest.getTreatments().isEmpty()) {
      content.append("Treatments Performed:\n");
      for (Treatment treatment : medicalCaseCloseRequest.getTreatments()) {
        content
            .append("- ")
            .append(treatment.getName())
            .append(" (")
            .append(treatment.getDetails())
            .append(")\n");
      }
      content.append("\n");
    }

    // Footer
    content.append(
        "If you have any questions or concerns, please don't hesitate to contact us.\n\n");
    content.append("Best regards,\n");
    content.append("Hospital Staff");

    return content.toString();
  }


}
