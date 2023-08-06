package JPAMappings.OneToMany.Example1.repository;

import JPAMappings.OneToMany.Example1.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface InstructorRepository extends JpaRepository<Instructor,Long> {

//    List<Instructor> findAllInstructorsEager();
}
