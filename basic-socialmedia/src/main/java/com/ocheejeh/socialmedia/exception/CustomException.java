package com.ocheejeh.socialmedia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.Optional;

/**
 * handle exceptions by replying custom/descriptive details
 * to the api user
 */
@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

    /**
     * if you intend to control all exceptions yourself, you can do such by anotating this
     * method for instance with @HandleException(Exception.class) and all exceptions will
     * be handle by the method implace of the spring standard ResponseEntityExceptionHandler class
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class) // This is only, if you intend to handle all api exception yourself
   public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * this will handle User not found class specific errors
     * with any details given via the error details object
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                ex.getMessage(),
                "The user id in this: " + request.getDescription(false) + " url does not exist");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
