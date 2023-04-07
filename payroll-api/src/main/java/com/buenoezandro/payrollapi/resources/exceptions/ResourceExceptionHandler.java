package com.buenoezandro.userapi.resources.exceptions;

import com.buenoezandro.userapi.services.exceptions.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(value = ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
        return status(NOT_FOUND).body(new StandardError(now(), ex.getMessage(), NOT_FOUND.value(), request.getRequestURI()));
    }
}
