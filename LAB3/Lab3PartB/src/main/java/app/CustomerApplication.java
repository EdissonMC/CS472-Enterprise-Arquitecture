package app;

import java.util.List;
import java.util.Optional;

import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.BookRepository;
import repositories.CustomerRepository;
import domain.Customer;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-> Creating Books :");
		System.out.println("-------------------------------\n");
		bookRepository.save(new Book(
								"Book1",
								"12313123",
								"Autor1",
								12313));

		bookRepository.save(new Book(
				"Book2",
				"222222",
				"Autor2",
				113.12));
		bookRepository.save(new Book(
				"Book3",
				"33333333",
				"Autor3",
				123.0));


		System.out.println("\n\n -> Books founded with findAll():");
		System.out.println("-------------------------------\n");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}

		System.out.println("\n-> Deleting book with id 1 :");
		System.out.println("-------------------------------");
		bookRepository.deleteById(1L);

		System.out.println("\n\n-> Listing all Books after delted 1 :");
		System.out.println("-------------------------------\n");
		for (Book book : bookRepository.findAll()) {
			System.out.println(book);
		}

		// fetch an individual book by ID and updating
		Optional<Book> custOpt = bookRepository.findById(2L);
		Book currentBook = custOpt.get();
		currentBook.setTitle("UPDATING TITLE");
		bookRepository.save(currentBook);

//
//		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
//		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
//		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
//		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
//		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));
//
//		// fetch all customers
//		System.out.println("Customers found with findAll():");
//		System.out.println("-------------------------------");
//		for (Customer customer : customerrepository.findAll()) {
//			System.out.println(customer);
//		}
//		System.out.println();
//
//		// fetch an individual customer by ID
//		Optional<Customer> custOpt = customerrepository.findById(1L);
//		Customer customer = custOpt.get();
//		System.out.println("Customer found with findOne(1L):");
//		System.out.println("--------------------------------");
//		System.out.println(customer);
//		System.out.println();

	}
}
