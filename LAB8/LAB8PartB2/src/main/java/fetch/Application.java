package fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        StopWatch stopwatch = new StopWatch();
        stopwatch.start();


        for (int x = 0; x < 10000; x++) {

            Person person = new Person("Person " + x);
            List<Pet> petlist = new ArrayList<Pet>();


            for (int y = 0; y < 10; y++) {
                Pet pet = new Pet("Pet" + x + "-" + y);
                petlist.add(pet);
            }
            person.setPets(petlist);
            personRepository.save(person);
        }


        stopwatch.stop();
        System.out.println("Saving data in database, take : "
                + stopwatch.getTotalTimeMillis() + " milliseconds.");


        stopwatch = new StopWatch();
        stopwatch.start();


        List<Person> personlist = personRepository.findAll();
        showData(personlist);
        System.out.println("We fetched " + personlist.size() + " records");

        stopwatch.stop();
        System.out.println("Fetch data time: " + stopwatch.getTotalTimeMillis() + " milliseconds.");
    }



    public static void showData(List<Person> personlist) {
		for (Person person : personlist) {
			for (Pet pet : person.getPets()) {
				System.out.println("Person name= " + person.getName() + "pet name= " + pet.getName());
			}
		}
    }


}
