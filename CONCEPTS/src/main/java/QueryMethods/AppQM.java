package QueryMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AppQM implements CommandLineRunner {

    @Autowired
    private UserRepoMethods userRepoMethods;

    @Autowired
    private UserRepoNative userRepoNative;

    public static void main(String[] args) {
        SpringApplication.run(AppQM.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("pancho", 8, true);
        User user2 = new User("panchita", 12, false);
        User user3 = new User("wandita", 14, true);
        User user4 = new User("panchota", 15, false);
        User user5 = new User("pancho", 23, true);
        User user6 = new User("yeyo", 45, true);


        userRepoMethods.save(user1);
        userRepoMethods.save(user2);
        userRepoMethods.save(user3);
        userRepoMethods.save(user4);
        userRepoMethods.save(user5);
        userRepoMethods.save(user6);


//        List<User> usersPancho =userRepoMethods.findByName("pancho");
//        System.out.println("SEARCH USERS PANCHO ");
//        System.out.println(usersPancho);

//        List<User> usersActived = userRepoMethods.findByActiveTrue();
//        List<User> usersActived = userRepoMethods.findByActive(true);
//        System.out.println("SEARCH USERS ACTIVED ");
//        System.out.println(usersActived);

//        System.out.println("SEARCH USERS START WITH panch ");
//        List<User> usersPanch= userRepoMethods.findByNameStartingWith("panch");
//        System.out.println(usersPanch);


//        System.out.println("SEARCH USERS HAS THAT pattern ");
//        String likePattern = "p%o";
//        List<User> usersPattern=  userRepoMethods.findByNameLike(likePattern);
//        System.out.println(usersPattern);

//         System.out.println("SEARCH USERS HAS LESS 15 YEARS ");
//        List<User> userLess15= userRepoMethods.findByAgeLessThan(15);
//        System.out.println(userLess15);

//        System.out.println("FIND JUST A USER BY ID");
//        Optional user = userRepoMethods.findById(1);
//        System.out.println(user.get());

        System.out.println("SEARCH USERS HAS LESS 15 YEARS ");
        List<User> usersActivedFromNative = userRepoNative.findAllActiveUsersNative();
        System.out.println(usersActivedFromNative);


    }
}
