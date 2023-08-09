package mvc;

import mvc.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(IOException.class)
    public void handleIOException(){

        //returning 404 error code
    }

    @ExceptionHandler(BookNotFoundException.class)
    public @ResponseBody ExceptionJSONInfo handleBookNotFoundException(HttpServletRequest request, Exception ex){
        System.out.println("-> HANDLING GLOBAL EXCEPTION");
        ExceptionJSONInfo response = new ExceptionJSONInfo();
        response.setUrl(request.getRequestURL().toString());
        response.setMessage(ex.getMessage());

        return response;
    }

}
