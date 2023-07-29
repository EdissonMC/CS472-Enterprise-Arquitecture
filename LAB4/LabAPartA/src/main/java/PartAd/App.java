package PartAd;


import PartAd.domain.School;
import PartAd.domain.Student;
import PartAd.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    SchoolRepository schoolRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student1 = new Student(1, "Student 1","last #2");
        Student student2 = new Student(2, "Student 2","last #3");

        School school = new School(" HighSchool #2");
        school.addStudent(student1);
        school.addStudent(student2);

        schoolRepository.save(school);


        Optional<School> schoolOpt = schoolRepository.findById(1L);
        School school2 = schoolOpt.get();

        System.out.println(school2);

    }

}