package PartAb;

import PartAb.domain.Book;
import PartAb.domain.Publisher;
import PartAb.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Book book = new Book(
                    "0001",
                    "Book1",
                "Author1");

        Publisher publisher = new Publisher("Publisher1");

        // ASSIGNING THE PUBLISHER TO THE BOOK
        book.setPublisher(publisher);

        // CREATING A BOOK IN THE DATABASE
        bookRepository.save(book);

        // RECOVERY A BOOK
        Optional<Book> bookOpt = bookRepository.findById(1L);
        Book book2 = bookOpt.get();
        System.out.println(book2);

    }

}

