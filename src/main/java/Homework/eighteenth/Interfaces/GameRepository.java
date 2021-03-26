package Homework.eighteenth.Interfaces;

import Homework.eighteenth.Classes.Game;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("GameRepository")
public interface GameRepository extends JpaRepository<Game,Long> {
    List<Game> findAllByCreationYear(int creationYear);
    List<Game> findAllByCreationYearAndName(int creationYear, String name);
    List<Game> findAllByName(String name);
    @NotNull List<Game> findAll();
    void deleteById(UUID id);
}
