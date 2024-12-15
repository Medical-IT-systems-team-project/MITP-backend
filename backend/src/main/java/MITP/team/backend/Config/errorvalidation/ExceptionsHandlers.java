package MITP.team.backend.Config.errorvalidation;

import MITP.team.backend.Exceptions.DataNotFoundException;
import MITP.team.backend.Exceptions.DuplicatedPatientException;
import MITP.team.backend.Exceptions.ServerInternalError;
import MITP.team.backend.Exceptions.UserNotFoundException;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiValidationErrorResponseDto handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        final List<String> errors = exception.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        log.warn("Validation error{}", errors);
        return ApiValidationErrorResponseDto.builder()
                .errors(errors)
                .status(HttpStatus.BAD_REQUEST)
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

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public DuplicateKeyExceptionDto handleMethodArgumentNotValidException(UserNotFoundException exception) {
        final String PatientNotFound = "Patient not found in system.";
        log.warn(PatientNotFound);
        return DuplicateKeyExceptionDto.builder()
                .message(PatientNotFound)
                .build();
    }

    @ExceptionHandler(ServerInternalError.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DuplicateKeyExceptionDto handleMethodArgumentNotValidException(ServerInternalError exception) {
        final String internalError = "Internal server error.";
        log.warn(internalError);
//      TODO dokonczyc

        return null;
    }
}
