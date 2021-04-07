package Homework.seventeenth.Entities;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Level")
public class Level {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "complexity")
    private String complexity;

    public  Level() {
    }

    public  Level(String name, String complexity) {
        this.name = name;
        this.complexity = complexity;
    }
    @ManyToOne
    public Game game;

    public Game getGame(){return game;}

    public String getName() {
        return name;
    }

    public String getComplexity() {
        return complexity;
    }
}
