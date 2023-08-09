package mvc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason = "Book Not Found") //404
public class BookNotFoundException extends Exception {
    private static final long serialVersionUID = 12345;
    String isbn;
    String operation;
    public BookNotFoundException(String  isbn, String operation) {
        super("BookNotFoundException with id=" + isbn);
        this.isbn= isbn;
        this.operation=operation;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
