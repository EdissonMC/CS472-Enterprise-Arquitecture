package Shop;

import Shop.domain.Cart;
import Shop.domain.Item;
import Shop.repositories.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppShop implements CommandLineRunner {


    @Autowired
    private CartRepository cartRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppShop.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cart cart = new Cart("Cart1");
        Item chocolate = new Item("001", cart);
        Item shampoo = new Item("002", cart);
        cart.setItem(chocolate);
        cart.setItem(shampoo);


        cartRepository.save(cart);

    }
}
