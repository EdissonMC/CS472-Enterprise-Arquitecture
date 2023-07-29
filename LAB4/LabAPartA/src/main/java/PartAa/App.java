package PartAa;

import PartAa.domain.Department;
import PartAa.domain.Employee;
import PartAa.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    DepartmentRepository departmentRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Department department = new Department("deparment 1");

        Employee employee1 = new Employee("Employee #1","00001");
        Employee employee2 = new Employee("Employee #2","00002");

        department.addEmployee(employee1);
        department.addEmployee(employee2);

        employee1.setDepartment(department);
        employee2.setDepartment(department);

        departmentRepository.save(department);


        Optional<Department> deptOpt = departmentRepository.findById(1L);
        Department department2 = deptOpt.get();

        System.out.println(department2);

    }

}
