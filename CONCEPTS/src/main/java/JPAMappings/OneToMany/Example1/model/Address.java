package JPAMappings.OneToMany.Example1.model;

import javax.persistence.*;

@Entity
@NamedQuery(name="Address.findAddressCounter", query="SELECT a.city , COUNT(a) FROM Address a JOIN a.user WHERE a.city=?1 GROUP BY a.city")
@NamedQuery(name="Address.findAddress", query="FROM Address a JOIN a.user WHERE a.city=?1")
@NamedQuery(name="Address.findStreet", query="FROM Address a WHERE a.street=:street")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String street;

    @OneToOne(
//            cascade = CascadeType.ALL,
//            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "user_id")
    private UserD user;

    public Address()
    {}
    public Address(String city,String street, UserD user) {
        this.city = city;
        this.user = user;
        this.street= street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
//                ", user=" + user +
                " street= " + street +
                '}';
    }
}

