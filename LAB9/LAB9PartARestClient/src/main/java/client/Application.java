package client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();
	private String serverUrl = "http://localhost:8081/books";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// get book1
		Book book1= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "1");
		System.out.println(book1);

//		// add book2
		Book book2= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "2");
		System.out.println(book2);
//
//		// get john
//		contact= restTemplate.getForObject(serverUrl+"/{firstName}", Contact.class, "John");
//		System.out.println(contact);
//
//		// delete book2
		restTemplate.delete(serverUrl+"/{isbn}", "2");
//
//		// update book1
		book1.setTitle("TITLE BOOK1 UPDATED");
		restTemplate.put(serverUrl+"/{isbn}" , book1, "1");
//
//		// get book1
		book1= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "1");
		System.out.println(book1);

//		// get all contacts
//		Contacts contacts = restTemplate.getForObject(serverUrl, Contacts.class);
//		System.out.println(contacts);


//
//
//
//		// get frank
//		Contact contact= restTemplate.getForObject(serverUrl+"/{firstName}", Contact.class, "Frank");
//		System.out.println(contact);
//
//		// add John
//		restTemplate.postForLocation(serverUrl, new Contact("John","Doe", "jdoe@acme.com", "6739127563"));
//
//		// get john
//		contact= restTemplate.getForObject(serverUrl+"/{firstName}", Contact.class, "John");
//		System.out.println(contact);
//
//		// delete mary
//		restTemplate.delete(serverUrl+"/{firstName}", "Mary");
//
//		// update John
//		contact.setEmail("johndoe@acme.com");
//		restTemplate.put(serverUrl+"/{firstName}" , contact, "John");
//
//		// get john
//		contact= restTemplate.getForObject(serverUrl+"/{firstName}", Contact.class, "John");
//		System.out.println(contact);
//        // get all contacts
//		Contacts contacts = restTemplate.getForObject(serverUrl, Contacts.class);
//		System.out.println(contacts);
//



	}
}
