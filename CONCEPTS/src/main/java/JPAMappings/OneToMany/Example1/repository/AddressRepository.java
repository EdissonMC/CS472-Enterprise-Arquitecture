package JPAMappings.OneToMany.Example1.repository;

import JPAMappings.OneToMany.Example1.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

//    List<Address> findAddressByCity(String city);
    List<Address> findAddress(String city);

    List<Address> findStreet(String street);
    Integer findAddressCounter(String city);

}
