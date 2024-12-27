package MITP.team.backend.Config.errorvalidation;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Exceptions.InvalidStatusTransitionException;
import MITP.team.backend.Exceptions.TreatmentNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@ControllerAdvice
public class ExceptionsHandlers {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public DuplicateKeyExceptionDto handleDataIntegrityViolationException() {
        final String loginAlreadyExists = "Login already exists";
        log.warn(loginAlreadyExists);
        return DuplicateKeyExceptionDto.builder()
                .message(loginAlreadyExists)
                .build();
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public UsernameNotFoundExceptionDto handleUsernameNotFoundException() {
        final String loginNotFound = "Login not found";
        log.warn(loginNotFound);
        return UsernameNotFoundExceptionDto.builder()
                .message(loginNotFound)
                .build();
    }

    @ExceptionHandler(TreatmentNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleTreatmentNotFoundException(TreatmentNotFoundException exception) {
        log.warn(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Treatment does not exist");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return errors;
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNotFoundExceptions(DataNotFoundException exception) {
        log.warn(exception.getMessage());
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(exception.getFieldName(), exception.getMessage());
        return errorMap;
    }

    @ExceptionHandler(InvalidStatusTransitionException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<?> handleInvalidStatusTransitionException(InvalidStatusTransitionException exception) {
        log.warn(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }
}
