package MITP.team.backend.Exceptions;

public class MedicalCaseNotFoundException extends RuntimeException {
  public MedicalCaseNotFoundException(String message) {
    super(message);
  }

  public MedicalCaseNotFoundException(Long id) {
    super("Medical case with id: " + id + " not found");
  }
}
