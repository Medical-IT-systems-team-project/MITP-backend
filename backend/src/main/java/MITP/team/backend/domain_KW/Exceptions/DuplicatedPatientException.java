package MITP.team.backend.domain_KW.Exceptions;

public class DuplicatedPatientException extends RuntimeException {
    public DuplicatedPatientException(String message) {
        super(message);
    }
}
