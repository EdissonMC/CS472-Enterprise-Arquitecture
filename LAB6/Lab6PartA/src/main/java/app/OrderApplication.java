package app;

import domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CDRepository;
import repositories.CustomerRepository;
import repositories.OrderRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class OrderApplication implements CommandLineRunner {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customeRepository;

    @Autowired
    CDRepository CDRepository;

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Order order1 = createOrder1(new Order("234743", "12/10/06", "open"));
        Order order2 = createOrder2(new Order("231678", "12/12/06", "closed"));
        Order order3 = createOrder3(new Order("555743", "12/10/06", "open"));
        Order order4 = createOrder4(new Order("555744", "12/10/06", "open"));

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);
        orderRepository.save(order4);

        Optional<Order> orderOpt = orderRepository.findById(1L);
        Order order = orderOpt.get();
//		showOrder(order);

//		-> Task: Give all customers.
//		List<Customer> customerList= customeRepository.findAll();
//       showData(customerList);

//		  -> Task: Give all CD’s from Michael Jackson with a price smaller than 10 euro
//        List<CD> CDList = CDRepository.findByArtistAndPriceLessThan("Michael Jackson", 10.0);
//        showData(CDList);

//        -> Task: Give all customers with zip code 2389HJ
//        List<Customer> customerList = customeRepository.findByAddressZip("2318KL");
//        showData(customerList);

//      -> Task:  Give all customers who ordered a DVD with the name The Greatest Showman
//        List<Customer> customerProducts = customeRepository.findByTheOrdersOrderlinesProductName("The Greatest Showman");
//        showData(customerProducts);



    }

    public <T>  void showData(List<T> listT){
        for (T item : listT) {
            System.out.println(item);
        }
//        return t;
    }

    private static Order createOrder1(Order order) {

        Customer c1 = new Customer("User1", "LastName1");
        Address a1 = new Address("Mainstreet 1", "New york", "43221", "USA");
        c1.setAddress(a1);

        OrderLine ol1 = createBook(new OrderLine(2), "J2ee design", "Good book on J2EE", 7.0, "Enterprise application development with J2EE");
        OrderLine ol2 = createCD(new OrderLine(4), "Dark Side of the Moon", "Album from 1973", 9.99, "Pink Floyd");

        order.addOrderLine(ol1);
        order.addOrderLine(ol2);
        order.setCustomer(c1);
        return order;
    }


    private static Order createOrder2(Order order) {
        Customer c1 = new Customer("John", "Doe");
        Address a1 = new Address("Hoofdstraat 1", "Amsterdam", "2318KL", "Netherlands");
        c1.setAddress(a1);


        OrderLine ol1 = createBook(new OrderLine(2), "Pride and Prejudice", "Classic novel", 7.99, "Jane Austen");
        OrderLine ol2 = createCD(new OrderLine(1), "Dark Side of the Moon", "Album from 1973", 9.99, "Pink Floyd");
        OrderLine ol3 = createCD(new OrderLine(1), "Rumors", "Album from 1977", 10.50, "Fleetwood Mac");
        OrderLine ol4 = createCD(new OrderLine(1), "Thriller", "Album from 1982", 7.99, "Michael Jackson");
        OrderLine ol5 = createDVD(new OrderLine(1), "The Greatest Showman", "Musical movie", 2.50, "Musical");


        order.addOrderLine(ol1);
        order.addOrderLine(ol2);
        order.addOrderLine(ol3);
        order.addOrderLine(ol4);
        order.addOrderLine(ol5);
        order.setCustomer(c1);
        return order;
    }

    private static Order createOrder3(Order order) {
        Customer c1 = new Customer("Mary", "Johnson");
        Address a1 = new Address("Mainstreet 1", "Boston", "82554", "USA");
        c1.setAddress(a1);

        OrderLine ol1 = createBook(new OrderLine(2), "The Lord of the Rings", "Fantasy novel", 12.00, "J.R.R. Tolkien");
        OrderLine ol2 = createDVD(new OrderLine(1), "The Greatest Showman", "Musical movie", 2.50, "Musical");
        OrderLine ol3 = createCD(new OrderLine(1), "Thriller", "Album from 1982", 17.99, "Michael Jackson");

        order.addOrderLine(ol1);
        order.addOrderLine(ol2);
        order.addOrderLine(ol3);
        order.setCustomer(c1);
        return order;
    }

    private static Order createOrder4(Order order) {
        Customer c1 = new Customer("Sue", "Moore");
        Address a1 = new Address("Rijnstraat 105", "Amsterdam", "2389HJ", "Netherlands");
        c1.setAddress(a1);

        OrderLine ol1 = createBook(new OrderLine(2), "J2ee design", "Book on J2EE", 7.0, "Enterprise application");
        OrderLine ol2 = createDVD(new OrderLine(1), "Inception", "Sci-Fi movie", 10.99, "Action");

        order.addOrderLine(ol1);
        order.addOrderLine(ol2);
        order.setCustomer(c1);
        return order;
    }


    private static OrderLine createDVD(OrderLine ol, String name, String description, Double price, String genre) {

        DVD dvd = new DVD();
        dvd.setName(name);
        dvd.setDescription(description);
        dvd.setPrice(price);
        dvd.setGenre(genre);
        ol.setProduct(dvd);
        return ol;
    }

    private static OrderLine createCD(OrderLine ol, String name, String description, Double price, String artist) {
        CD cd = new CD();
        cd.setName(name);
        cd.setDescription(description);
        cd.setPrice(price);
        cd.setArtist(artist);
        ol.setProduct(cd);
        return ol;
    }

    private static OrderLine createBook(OrderLine ol, String name, String description, Double price, String title) {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);
        book.setPrice(price);
        book.setTitle(title);

        ol.setProduct(book);
        return ol;
    }

    public static void showOrder(Order order) {


        System.out.println("Order with orderNumber: " + order.getOrdernr());
        System.out.println("Order date: " + order.getDate());
        System.out.println("Order status: " + order.getStatus());
        Customer cust = order.getCustomer();
        System.out.println("Customer: " + cust.getFirstname() + " " + cust.getLastname());
        System.out.println("Address: " + cust.getAddress().getStreet() + " " + cust.getAddress().getCity() + cust.getAddress().getZip() + " " + cust.getAddress().getCountry());

        Iterator iter = order.getOrderlines().iterator();
        while (iter.hasNext()) {
            OrderLine orderline = (OrderLine) iter.next();
            System.out.println("Order line: quantity= " + orderline.getQuantity());
            System.out.println(orderline.getProduct());
        }
    }
}

