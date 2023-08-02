package app;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CourseRepository;
import repositories.DepartmentRepository;
import repositories.GradeRepository;
import repositories.StudentRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Application implements CommandLineRunner {
    @Autowired
    GradeRepository gradeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        // DEPARMENT #1
        Department department1 = new Department("Deparment #1");
        departmentRepository.save(department1);

        Student student1 = new Student(1L, "Student #1");
        Student student2 = new Student(2L, "Student #2");

        Course course1 = new Course("Couse #1");
        Course course2 = new Course("Couse #2");
        Course course3 = new Course("Couse #3");


        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);

        Grade grade1 = new Grade(course1, "B+");
        gradeRepository.save(grade1);
        student1.addGrade(grade1);

        Grade grade2 = new Grade(course2, "A-");
        gradeRepository.save(grade2);
        student1.addGrade(grade2);
        student1.setDepartment(department1);
        student2.setDepartment(department1);


        // DEPARMENT #2
        Department department2 = new Department("Deparment #2");
        departmentRepository.save(department2);

        Student student3 = new Student(3L, "Student #3");
        Student student4 = new Student(3L, "Student #4");
        student3.setDepartment(department2);
        student4.setDepartment(department2);

        Grade grade3 = new Grade(course1, "B");
        gradeRepository.save(grade3);
        student2.addGrade(grade3);

        Grade grade4 = new Grade(course1, "C");
        gradeRepository.save(grade4);
        student3.addGrade(grade4);

        Grade grade5 = new Grade(course2, "A+");
        gradeRepository.save(grade5);
        student3.addGrade(grade5);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        // -> Get all students from a certain department
        List<Student> students1 = studentRepository.findByDepartmentName("Deparment #1");
        System.out.println("-> Get all students from a certain department 'Deparment #1' ");
        students1.stream().forEach(c -> System.out.println(c));

        // -> Get all students from a certain department
        List<Student> students2 = studentRepository.getStudentsFromDepartment("Deparment #2");
        System.out.println("-> Get all students from a certain department 'Deparment #2' ");
        students2.stream().forEach(c -> System.out.println(c));

        // -> Get all students who took a course with a certain name.
        List<Student> students3 = studentRepository.getStudentsWhoTookCourse("Couse #1");
        System.out.println("-> Get all students who took a course with a certain name.");
        students3.stream().forEach(c -> System.out.println(c));



    }

}

