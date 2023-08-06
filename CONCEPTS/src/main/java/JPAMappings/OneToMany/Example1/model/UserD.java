package JPAMappings.OneToMany.Example1.model;


import javax.persistence.*;

@Entity
@NamedQuery(name = "UserD.findByNamee", query = "FROM UserD WHERE name=?1")
@NamedQuery(name = "UserD.findByCity", query = "SELECT DISTINCT u.address.city FROM UserD u WHERE u.address.city=?1")
public class UserD {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String name;

    @OneToOne(
            cascade = CascadeType.ALL
            , mappedBy = "user"
//          ,fetch = FetchType.EAGER
    )
    private Address address;

    public UserD() {

    }

    public UserD(String name) {
        this.name = name;

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

}
