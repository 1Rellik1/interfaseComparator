package Homework.seventeenth.Entities;

import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Game")
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name) &&
                Objects.equals(creationYear, game.creationYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationYear);
    }
}
