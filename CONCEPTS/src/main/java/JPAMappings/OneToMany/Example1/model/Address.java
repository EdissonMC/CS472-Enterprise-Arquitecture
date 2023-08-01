package JPAMappings.OneToMany.Example1.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Address()
    {}
    public Address(String city, User user) {
        this.city = city;
        this.user = user;
    }


}

