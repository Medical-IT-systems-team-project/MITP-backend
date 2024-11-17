package MITP.team.backend.Exceptions;

public class DuplicatedPatientException extends RuntimeException {
    public DuplicatedPatientException(String message) {
        super(message);
    }
}
