package repositories;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByAddressZip(String zip);

    List<Customer> findByTheOrdersOrderlinesProductName(String name);


    List<Customer> getAllCustomersFromCountry(@Param("country")String country);
    List<String> getAllCustomersNameFromCountry(String country);
//    @Query("select c from Customer c where c.address.country = :country")
//    List<Customer> getAllCustomersFromCountry(@Param("country")String country);

    @Query("SELECT c FROM Customer c INNER JOIN c.theOrders o INNER JOIN o.orderlines ol " +
            "INNER JOIN ol.product p WHERE TYPE(p)= CD AND p.artist=:artist" )
//    @Query("SELECT c FROM Customer c INNER JOIN c.theOrders.orderlines.product p " +
//            "WHERE TYPE(p)= CD AND p.artist=:artist")
    List<Customer>getALLCustomersThatBoughtCDByArtist(@Param("artist") String artist);

    @Query("select c from Customer c where c.address.city = :city")
    List<Customer> getAllCustomersFromCity(@Param("city")String amsterdam);
}
