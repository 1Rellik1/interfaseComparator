package Homework.eighteenth.Interfaces;


import Homework.eighteenth.Classes.Game;
import Homework.eighteenth.Classes.Level;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("LevelRepository")
public interface LevelRepository extends JpaRepository<Level,Long> {
    List<Level> findAllByComplexity(String complexity);
    List<Level> findAllByComplexityAndName(String complexity, String name);
    List<Level> findAllByName(String name);
    Level findById(UUID id);
    @NotNull List<Level> findAll();
    void deleteById(UUID id);
}
