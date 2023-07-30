package QueryMethods;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepoMethods extends JpaRepository<User,Integer> {

    List<User> findByName(String name);
    List<User> findByActiveTrue();
    List<User> findByActive(Boolean status);

    List<User> findByNameStartingWith(String prefix);
    List<User> findByNameLike(String likePattern);

    List<User> findByAgeLessThan(Integer limit);



}
