package mvc.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Book Not Found") //404
public class BookNotFoundException extends Exception {
    private static final long serialVersionUID = 12345;

    public BookNotFoundException(int id) {
        super("BookNotFoundException with id=" + id);
    }
}
