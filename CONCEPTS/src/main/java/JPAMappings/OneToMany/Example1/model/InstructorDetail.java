package JPAMappings.OneToMany.Example1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String hobby;
    private String channel;

    public InstructorDetail() {
    }

    public InstructorDetail(String hobby, String channel) {
        this.hobby = hobby;
        this.channel = channel;
    }

    @Override
    public String toString() {
        return "\nInstructorDetail{" +
                "id=" + id +
                ", hobby='" + hobby + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
