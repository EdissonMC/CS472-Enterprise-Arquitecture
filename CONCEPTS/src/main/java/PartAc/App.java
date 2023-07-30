package PartAc;

import PartAc.domain.Flight;
import PartAc.domain.Passenger;
import PartAc.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    PassengerRepository passengerRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        // CREATING SOM FLIGHS OBJECTS
        Flight flight1 = new Flight(1,"City #1", "City #2", new Date());
        Flight flight2 = new Flight(2,"City #2", "City #3", new Date());
        Flight flight3 = new Flight(3,"City #3", "City #4", new Date());


        Passenger passenger = new Passenger("Panchito");


        passenger.addFlight(flight1);
        passenger.addFlight(flight3);
        passenger.addFlight(flight2);

        passengerRepository.save(passenger);


        Optional<Passenger> passengerOpt = passengerRepository.findById(1L);
        Passenger passenger2 = passengerOpt.get();

        System.out.println("-> PASSENGER HISTORY TRAVEL: ");
        System.out.println(passenger2);

    }

}
