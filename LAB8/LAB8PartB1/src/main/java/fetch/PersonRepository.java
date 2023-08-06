package fetch;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query("select distinct o from Owner o join fetch o.pets")
    List<Person> findOwners();
}
