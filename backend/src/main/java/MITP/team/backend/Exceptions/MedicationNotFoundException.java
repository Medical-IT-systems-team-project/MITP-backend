package MITP.team.backend.Exceptions;

public class MedicationNotFoundException extends DataNotFoundException {
    public MedicationNotFoundException() {
        super("medication");
    }

    @Override
    public String getMessage() {
        return "Medication not found";
    }
}
