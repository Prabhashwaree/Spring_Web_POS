package lk.ijse.springwebpos.advisor;

import lk.ijse.springwebpos.util.ResponceUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})

    public ResponceUtil exceptionHandler(Exception e) {
        return new ResponceUtil(500, e.getMessage(), null);
    }
}
