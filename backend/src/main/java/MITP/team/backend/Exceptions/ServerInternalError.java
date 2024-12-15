package MITP.team.backend.Exceptions;

public class ServerInternalError extends RuntimeException {
    public ServerInternalError(Exception s) {
        super(s);
    }
}
