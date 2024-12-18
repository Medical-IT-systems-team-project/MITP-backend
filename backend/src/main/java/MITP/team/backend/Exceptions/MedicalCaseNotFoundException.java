package MITP.team.backend.Exceptions;

public class MedicalCaseNotFoundException extends DataNotFoundException {
  public MedicalCaseNotFoundException() {
    super("medicalCase");
  }

  @Override
  public String getMessage() {
    return "Medical case not found";
  }
}
