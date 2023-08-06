package domain;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="CD.searchByArtist" , query="SELECT cd FROM CD cd WHERE cd.artist=:artist")
public class CD extends Product{
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "CD{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                " artist='" + artist + '\'' +
                '}';
    }
}
