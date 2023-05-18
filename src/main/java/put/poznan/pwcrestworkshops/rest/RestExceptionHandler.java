package put.poznan.pwcrestworkshops.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import put.poznan.pwcrestworkshops.dto.ExceptionResponse;
import put.poznan.pwcrestworkshops.exceptions.RepoException;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(RepoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMyException(RepoException e) {
        log.warn("Unexpected exception", e);
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(e.getMessage())
                .build();
    }
}
