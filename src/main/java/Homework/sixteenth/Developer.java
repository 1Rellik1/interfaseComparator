package Homework.sixteenth;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Developers")
public class Developer {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "developer")
    private List<Game> game;
}
