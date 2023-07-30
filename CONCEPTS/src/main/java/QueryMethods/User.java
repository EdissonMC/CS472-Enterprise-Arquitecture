package QueryMethods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;
import java.util.Date;

@Table(name = "users")
@Entity
class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Integer age;
    private ZonedDateTime birthDate;
    private Boolean active;

    public User( ) {

    }

    public User(String name, Integer age, Boolean active) {
        this.name = name;
        this.age = age;
        this.active = active;
        birthDate= ZonedDateTime.now();;
    }

    // standard getters and setters


    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthDate=" + birthDate +
                ", active=" + active +
                '}';
    }
}