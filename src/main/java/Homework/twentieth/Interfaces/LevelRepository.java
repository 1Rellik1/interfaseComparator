package Homework.twentieth.Interfaces;


import Homework.twentieth.Classes.Level;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LevelRepository extends JpaRepository<Level,Long> {
    List<Level> findAllByComplexity(String complexity);
    List<Level> findAllByComplexityAndName(String complexity, String name);
    List<Level> findAllByName(String name);
    Level findById(UUID id);
    @NotNull List<Level> findAll();
    void deleteById(UUID id);
}
