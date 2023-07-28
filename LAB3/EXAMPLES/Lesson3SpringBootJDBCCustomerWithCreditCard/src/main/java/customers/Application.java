package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private ProductDAO productDAO;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		customerDao.clearDB();
//		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
//		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
//		customer.setCreditCard(creditCard);
//		customerDao.save(customer);
//		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
//		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
//		customer.setCreditCard(creditCard);
//		customerDao.save(customer);
//		System.out.println(customerDao.getCustomer(101));
//		System.out.println(customerDao.getCustomer(66));
//		System.out.println("-----------All customers ----------------");
//		System.out.println(customerDao.getAllCustomers());

        productDAO.clearDB();

        Product product = new Product(10, "TV", 100.0);
        Supplier supplier = new Supplier("samsung","0000101");
        product.setSupplier(supplier);
        productDAO.save(product);

        product = new Product(11, "LAPTOP", 1200.0);
        supplier = new Supplier("apple","0000202");
        product.setSupplier(supplier);
        productDAO.save(product);



        System.out.println("-----------All products ----------------");
        System.out.println(productDAO.getAllProducts());
//
//        System.out.println("\n-----------Specific product #10 ----------------");
//        System.out.println(productDAO.findByProductNumber(10));

//        System.out.println("\n-----------Specific productBy Name #LAPTOP ----------------");
//        System.out.println(productDAO.findByProductName("LAPTOP"));
//
        System.out.println("\n-----------Delete specific productBy ID #11 ----------------");
        System.out.println(productDAO.deleteProductByNumber(11));
//
        System.out.println("\n-----------All products ----------------");
        System.out.println(productDAO.getAllProducts());

//        System.out.println(productDAO.getSupplierByProduct(10));
    }
}
