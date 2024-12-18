package MITP.team.backend.Exceptions;

import lombok.Getter;

@Getter
public class DataNotFoundException extends RuntimeException {
    private final String fieldName;

    public DataNotFoundException(String fieldName) {
        super();
        this.fieldName = fieldName;
    }

}