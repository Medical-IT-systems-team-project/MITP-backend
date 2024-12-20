package MITP.team.backend.Exceptions;

public class TreatmentNotFoundException extends DataNotFoundException {
    public TreatmentNotFoundException() {
        super("treatment");
    }

    @Override
    public String getMessage() {
        return "Treatment not found";
    }
}
