package bank.dao;

import bank.domain.TraceData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraceDataDAO extends JpaRepository<TraceData,Long> {
}
