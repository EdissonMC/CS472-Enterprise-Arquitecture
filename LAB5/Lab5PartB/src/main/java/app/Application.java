package app;

import domain.Appointment;
import domain.Doctor;
import domain.Patient;
import domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.AppointmentRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Application implements CommandLineRunner{
	@Autowired
	AppointmentRepository appointmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Doctor doctor1 = new Doctor("Pediatrician", "John", "Smith");
		Doctor doctor2 = new Doctor("Cardiologist", "Emily", "Johnson");
		Doctor doctor3 = new Doctor("Dentist", "Michael", "Williams");
		Doctor doctor4 = new Doctor("Neurologist", "Sophia", "Garcia");

		Payment payment1 = new Payment("10-07-2023", 210.50);
		Payment payment2 = new Payment("11-07-2023", 349.70);
		Payment payment3 = new Payment("12-07-2023", 193.60);
		Payment payment4 = new Payment("13-07-2023", 251.80);

		 Patient patient1 = new Patient("Alice Johnson", "15 Elm Street", "54321", "Los Angeles");
		 Patient patient2 = new Patient("Robert Smith", "22 Maple Lane", "98765", "Chicago");
		 Patient patient3 = new Patient("Emily Williams", "8 Oak Drive", "74563", "Houston");
		 Patient patient4 = new Patient("Michael Brown", "10 Pine Road", "35678", "Miami");

		Appointment appointment1 = new Appointment("10-11-2023", patient1, payment1, doctor1);
		Appointment appointment2 = new Appointment("11-11-2023", patient2, payment2, doctor2);
		Appointment appointment3 = new Appointment("12-11-2023", patient3, payment3, doctor3);
		Appointment appointment4 = new Appointment("14-11-2023", patient4, payment4, doctor4);

		appointmentRepository.save(appointment1);
		appointmentRepository.save(appointment2);
		appointmentRepository.save(appointment3);
		appointmentRepository.save(appointment4);

		List<Appointment> appList = appointmentRepository.findAll();
		for (Appointment appointment : appList){
			System.out.println(appointment);
		}

	}

}

