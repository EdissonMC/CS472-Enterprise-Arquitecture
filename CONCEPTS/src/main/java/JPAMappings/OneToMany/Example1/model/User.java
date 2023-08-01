package JPAMappings.OneToMany.Example1.model;


import javax.persistence.*;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @OneToOne (mappedBy = "user")
    private Address address;

    public User(){

    }
    public User(String name ) {
        this.name = name;

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
