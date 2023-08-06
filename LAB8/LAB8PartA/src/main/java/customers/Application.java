package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Address address1 = new Address("First Avenue 123", "New York", "10001");
        Student student1 = new Student(1, "John Smith", "123456789", "john.smith@example.com");
        student1.setAddress(address1);
        student1.addGrade(new Grade("Mathematics", "A+"));
        student1.addGrade(new Grade("Physics", "A-"));
        studentRepository.save(student1);

        Address address2 = new Address("Second Street 456", "Los Angeles", "90001");
        Student student2 = new Student(2, "Alice Johnson", "987654321", "alice.johnson@example.com");
        student2.setAddress(address2);
        student2.addGrade(new Grade("History", "B+"));
        student2.addGrade(new Grade("English", "A-"));
        studentRepository.save(student2);


        System.out.println(studentRepository.findById(1).get());
        System.out.println(studentRepository.findById(2).get());
        System.out.println("-----------All customers ----------------");
        System.out.println(studentRepository.findAll());

        System.out.println("-----------find by name ----------------");
        List<Student> students = studentRepository.findByName("Sue Ellen");
        students.forEach(s->System.out.println(s));
        System.out.println("-----------find by phone ----------------");
        System.out.println(studentRepository.findByPhone("234123432"));

        System.out.println("-----------find by city ----------------");
        students = studentRepository.findByCity("Chicago");
        students.forEach(s->System.out.println(s));

        System.out.println("-----------find by course name ----------------");
        students = studentRepository.findByCourse("Programming 1");
        students.forEach(s->System.out.println(s));

        System.out.println("-----------find by course name and grade----------------");
        students = studentRepository.findByCourseAndGrade("Programming 1", "A+");
        students.forEach(s->System.out.println(s));


        // create customer
//		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
//		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
//		creditCard = new CreditCard("657483342", "Visa", "09/23");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
//		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
//		customer.setCreditCard(creditCard);
//		customerRepository.save(customer);
//		//get customers
//		System.out.println(customerRepository.findById(66).get());
//		System.out.println(customerRepository.findById(101).get());
//		System.out.println("-----------All customers ----------------");
//		System.out.println(customerRepository.findAll());
//		//update customer
//		customer = customerRepository.findById(101).get();
//		customer.setEmail("jd@gmail.com");
//		customerRepository.save(customer);
//		System.out.println("-----------find by phone ----------------");
//		System.out.println(customerRepository.findByPhone("0622341678"));
//		System.out.println("-----------find by email ----------------");
//		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
//		System.out.println("-----------find customers with a certain type of creditcard ----------------");
//		List<Customer> customers = customerRepository.findByCreditCardType("Visa");
//		for (Customer cust : customers){
//			System.out.println(cust);
//		}

    }

}
