package repositories;

import domain.CD;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o.ordernr from Order o where o.status = 'closed'")
    List<String> getOrderNumbersFromOrdersWithStatusClosed();

    @Query("select o.ordernr from Order o where o.customer.address.city = :city")
    List<String> getOrderNumbersFromOrdersFromCity(@Param("city")String city);

}
