package mvc;

import mvc.exceptions.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class BookController {

    Map<String, Book> books = new HashMap<>();
    Integer counter = 0;

    public BookController() {
        books.put("1", new Book("1", "Author1", "title1", 10.0));
        books.put("2", new Book("2", "Author2", "title2", 12.0));
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.put(book.isbn, book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }


    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book book) throws BookNotFoundException{

        if (isbn == null) {
            throw new BookNotFoundException(isbn, "TRYING TO UPDATE A BOOK WITHOUT isbn");
        }

        Book bookCheker = books.get(isbn);

        if (book == null) {

            throw new BookNotFoundException(isbn, "TRYING TO UPDATE A BOOK DOESNT EXIST");
        }
        books.put(isbn, book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }


    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable(required = false) String isbn) throws BookNotFoundException {
        System.out.println("DELETING BOOK WITH isbn: " + isbn);
        counter++;
        System.out.println("REQUEST " + counter);
        if (isbn == null) {
            throw new BookNotFoundException(isbn, "TRYING TO DELETE A BOOK WITHOUT isbn");
        }

        Book book = books.get(isbn);

        System.out.println("book" + book);

        if (book == null) {

            throw new BookNotFoundException(isbn, "TRYING TO DELETE A BOOK DOESNT EXIST");
//            return new ResponseEntity<CustomErrorType>(
//
//                    new CustomErrorType("Book with isbn= " + isbn + " is not available"),
//                    HttpStatus.NOT_FOUND);

        }
        books.remove(isbn);
        return new ResponseEntity<>(HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        System.out.println("GETTING BOOK WITH isbn: " + isbn);
        counter++;
        System.out.println("REQUEST " + counter);
        Book book = books.get(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Book with isbn = "
                            + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }


    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        counter++;
        System.out.println("GET ALL CONTACTS REQUEST..." + counter);
        //Book book = new Book("1", "Author1", "Title1", 10.0);
        Books allBooks = new Books(books.values());
        return new ResponseEntity<Books>(allBooks, HttpStatus.OK);
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String getTest(@PathVariable("id") int id) throws Exception {
//
        if (id == 1) {
            throw new BookNotFoundException("ISBN", "TESING...");
        } else if (id == 3) {
            throw new IOException("IOException, id=" + id);

        } else {
            throw new Exception("Generic Exception, id=" + id);
        }
//
//            return "testing";
    }

//    searchBooks(String author){
//
//    }
}
