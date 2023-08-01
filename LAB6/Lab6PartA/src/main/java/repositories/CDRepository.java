package repositories;

import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CDRepository extends JpaRepository<CD,Long> {

    public List<CD> findByArtistAndPriceLessThan(String artist, Double price);
}
