package MITP.team.backend.Config.errorvalidation;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Exceptions.DuplicatedPatientException;
import MITP.team.backend.Exceptions.MedicalDoctorNotFoundException;
import MITP.team.backend.Exceptions.PatientNotFoundException;
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

    @ExceptionHandler(DuplicatedPatientException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public DuplicateKeyExceptionDto handleMethodArgumentNotValidException(DuplicatedPatientException exception) {
        final String loginNotFound = "Patient already exist in system.";
        log.warn(loginNotFound);
        return DuplicateKeyExceptionDto.builder()
                .message(loginNotFound)
                .build();
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DuplicateKeyExceptionDto handleMethodArgumentNotValidException(DataNotFoundException exception) {
        final String notFound = exception.getMessage();
        log.warn(notFound);
        return DuplicateKeyExceptionDto.builder()
                .message(notFound)
                .build();
    }

    @ExceptionHandler(MedicalDoctorNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handleMedicalDoctorNotFoundException(MedicalDoctorNotFoundException exception) {
        log.warn(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor does not exist");
    }

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> handlePatientNotFoundException(PatientNotFoundException exception) {
        log.warn(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Patient does not exist");


    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        System.out.println(ex.getBindingResult().getFieldErrors());

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return errors;
    }
}
