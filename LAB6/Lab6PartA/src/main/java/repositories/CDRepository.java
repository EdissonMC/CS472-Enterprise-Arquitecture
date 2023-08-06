package repositories;

import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CDRepository extends JpaRepository<CD,Long> {

    public List<CD> findByArtistAndPriceLessThan(String artist, Double price);

    public List<CD> searchByArtist(@Param("artist") String artist);
//    @Query(value = "select * from cd inner join product on cd.id=product.id where artist = :artist",nativeQuery = true)
//    List<CD> findByAnArtist(@Param("artist")String artist);
//
//    @Query("select cd from CD cd where cd.artist= :artist and cd.price > :price")
//    List<CD> getAllCDsFromArtistAndPriceBiggerThan(@Param("artist")String artist, @Param("price")double price);
}
