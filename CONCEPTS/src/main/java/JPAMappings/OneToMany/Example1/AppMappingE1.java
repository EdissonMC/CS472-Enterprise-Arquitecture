package JPAMappings.OneToMany.Example1;


import JPAMappings.OneToMany.Example1.model.Address;
import JPAMappings.OneToMany.Example1.model.Instructor;
import JPAMappings.OneToMany.Example1.model.InstructorDetail;
import JPAMappings.OneToMany.Example1.model.User;
import JPAMappings.OneToMany.Example1.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class AppMappingE1 implements CommandLineRunner {

    @Autowired
    InstructorRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(AppMappingE1.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user= new User("Pnachito");
        Address address=new Address("new york",user);
        user.setAddress(address);

//        createInstructors();
    }


    public   void createInstructors(){
        Instructor instructor1 = new Instructor("pancho1", "lastname1", "email@miu.edu");
        InstructorDetail instructorDetail = new InstructorDetail("basketball", "chanel#1");
        instructor1.setInstructorDetail(instructorDetail);
        repo.save(instructor1);

        List<Instructor> instructors = repo.findAll();


        for (Instructor inst:instructors){
            System.out.println(inst);
        }

    }
}
