package JPAMappings.OneToMany.Example1;


import JPAMappings.OneToMany.Example1.model.Address;
import JPAMappings.OneToMany.Example1.model.Instructor;
import JPAMappings.OneToMany.Example1.model.InstructorDetail;
import JPAMappings.OneToMany.Example1.model.UserD;
import JPAMappings.OneToMany.Example1.repository.AddressRepository;
import JPAMappings.OneToMany.Example1.repository.InstructorRepository;
import JPAMappings.OneToMany.Example1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppMappingE1 implements CommandLineRunner {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppMappingE1.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        UserD user1 = createUser("Panchito", "8 st", "new york");
        userRepository.save(user1);

        UserD user2 = createUser("Wandita", "1 st", "chicago");
        userRepository.save(user2);

        UserD user3 = createUser("Panchita", "4 st", "chicago");
        userRepository.save(user3);

        // QUERY BUILD IN
//        List<UserD> listUsers= userRepository.findAll();
//        for (UserD userItem: listUsers){
//            System.out.println(userItem);
//        }

//        UserD userD1= userRepository.findByNamee("Panchito");
//        List<UserD> users= userRepository.findByCity("chicago");
//        List<Address> addresses = addressRepository.findAddress("chicago");
//        List<Address> addresses = addressRepository.findAddress("new york");
//        System.out.println(addresses);
        List<Address> addressByStreet = addressRepository.findStreet("4 st");
        System.out.println(addressByStreet);
//        Integer addressesCounter = addressRepository.findAddressCounter("chicago");
//        System.out.println(addresses);

//        createInstructors();
    }

    public static UserD createUser(String name, String street, String city) {
        UserD user2 = new UserD(name);
        Address address2 = new Address(city, street, user2);
        user2.setAddress(address2);
        return user2;
    }


    public void createInstructors() {
        Instructor instructor1 = new Instructor("pancho1", "lastname1", "email@miu.edu");
        InstructorDetail instructorDetail = new InstructorDetail("basketball", "chanel#1");
        instructor1.setInstructorDetail(instructorDetail);
        instructorRepository.save(instructor1);

        List<Instructor> instructors = instructorRepository.findAll();


        for (Instructor inst : instructors) {
            System.out.println(inst);
        }

    }
}
