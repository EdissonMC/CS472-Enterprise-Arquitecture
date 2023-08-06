package JPAMappings.OneToMany.Example1.repository;

import JPAMappings.OneToMany.Example1.model.UserD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface UserRepository extends JpaRepository<UserD,Long> {

    UserD findByNamee(String name);
    List<UserD> findByCity(String city);
}
