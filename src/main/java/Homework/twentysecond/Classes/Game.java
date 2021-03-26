package Homework.twentysecond.Classes;

import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "Game")
@Entity
public class Game {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "creation_year")
    @NotNull
    private int creationYear;

    public Game() {
    }

    public Game(String name, int creationYear) {
        this.name = name;
        this.creationYear = creationYear;
    }
    @OneToMany(mappedBy = "game")
    private List<Level> levels = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getCreationYear() {
        return creationYear;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationYear=" + creationYear +
                ", levels=" + levels +
                '}';
    }
}
