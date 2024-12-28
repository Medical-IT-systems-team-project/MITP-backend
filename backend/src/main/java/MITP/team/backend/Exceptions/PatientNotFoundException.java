package MITP.team.backend.Exceptions;

public class PatientNotFoundException extends DataNotFoundException {
    public PatientNotFoundException() {
        super("patient");
    }

    @Override
    public String getMessage() {
        return "Patient not found";
    }
}
