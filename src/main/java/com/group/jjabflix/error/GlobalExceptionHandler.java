package com.group.jjabflix.error;

import com.group.jjabflix.user.exception.EmailDuplicationException;
import com.group.jjabflix.user.exception.NotFoundUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailDuplicationException.class)
    public ResponseEntity<ErrorResponse> handleEmailDuplicationException(
        EmailDuplicationException e) {
        log.error("handleEmailDuplicationException: {}", e.getMessage());
        ErrorResponse response = ErrorResponse.of(
            e.getErrorCode()
        );

        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @ExceptionHandler(NotFoundUserException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundUserException(
        NotFoundUserException e) {
        log.error("handleNotFoundUserException: {}", e.getMessage());
        ErrorResponse response = ErrorResponse.of(
            e.getErrorCode()
        );

        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
