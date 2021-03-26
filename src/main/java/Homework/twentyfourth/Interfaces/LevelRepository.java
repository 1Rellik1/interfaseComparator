package Homework.twentyfourth.Interfaces;


import Homework.twentyfourth.Classes.Level;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LevelRepository extends JpaRepository<Homework.twentyfourth.Classes.Level,Long> {
    List<Homework.twentyfourth.Classes.Level> findAllByComplexity(String complexity);
    List<Homework.twentyfourth.Classes.Level> findAllByComplexityAndName(String complexity, String name);
    List<Homework.twentyfourth.Classes.Level> findAllByName(String name);
    Homework.twentyfourth.Classes.Level findById(UUID id);
    @NotNull List<Level> findAll();
    void deleteById(UUID id);
}
