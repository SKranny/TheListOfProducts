package main.exception;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Getter
public class ListException extends RuntimeException {
    private final HttpStatus status;

    public ListException(String message,HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ListException(Throwable ex,HttpStatus status) {
        super(ex.getMessage());
        this.status = status;
    }

    public ListException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

}
