package QueryMethods;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface UserRepoNative  extends JpaRepository<User,Integer> {

    @Query(
            value = "SELECT * FROM USERS u WHERE u.active = true",
            nativeQuery = true)
    List<User> findAllActiveUsersNative();

}
