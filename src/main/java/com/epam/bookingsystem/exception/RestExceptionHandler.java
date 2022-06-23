package com.epam.bookingsystem.exception;

import com.epam.bookingsystem.exception.dto.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Locale;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {





    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(EntityNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getClass().getSimpleName(),
                ex.getMessage(), request.getDescription(false), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler({EntityAlreadyExistsException.class})
    protected ResponseEntity<Object> handleConflict(EntityAlreadyExistsException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getClass().getSimpleName(),
                ex.getMessage(), request.getDescription(false), 409);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);
    }

    @ExceptionHandler()
    protected ResponseEntity<Object> handleIncorrectCurrentPasswordException(IncorrectCurrentPasswordException exception, WebRequest request) {
        log.error("IncorrectCurrentPasswordException handler , " + "message = "
                + exception.getMessage() + " , exception type is " + exception.getClass().getName());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                exception.getMessage(), request.getDescription(false), 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler()
    protected ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        log.error("all exception handler , " + "message = "
                + exception.getMessage() + " , exception type is " + exception.getClass().getName());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                exception.getMessage(), request.getDescription(false), 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler()
    protected ResponseEntity<Object> handleAllRuntimeExceptions(RuntimeException exception, WebRequest request) {
        log.error("all RuntimeException handler , " + "message = "
                + exception.getMessage() + " , exception type is " + exception.getClass().getName());
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                exception.getMessage(), request.getDescription(false), 400);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler({AuthenticationException.class})
    protected ResponseEntity<ErrorDetails> handleAuthenticationException(AuthenticationException exception, WebRequest request) {
        log.error("exception type is " + exception.getClass().getSimpleName() + " , message = " +
                exception.getMessage() + " , description " + request.getDescription(false));
        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                exception.getMessage(), request.getDescription(false), 401);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDetails);
    }

    @ExceptionHandler({RedisConnectionFailureException.class})
    protected ResponseEntity<ErrorDetails> handleRedisConnectionFailureException(RedisConnectionFailureException exception, WebRequest request) {

        log.error("exception type is " + exception.getClass().getSimpleName() + " , message = " +
                exception.getMessage() + " , description " + request.getDescription(false));

        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getClass().getSimpleName(),
                // todo let this message to be deleted when the development branch is merging to the master branch
                exception.getMessage() + "The most likely causes of the failure may be\n" +
                        "1 Redis database is not running\n" +
                        "2 Password of the Redis database has not been set", request.getDescription(false), 500);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

}