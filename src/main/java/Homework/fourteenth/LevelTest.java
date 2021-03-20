package Homework.fourteenth;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LevelTest {
    private List<Level> levels;

    public LevelTest() {
        levels = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        levels.add(new Level("Firts", "Easy"));
        levels.add(new Level("Second", "Easy"));
        levels.add(new Level("Third", "Easy"));
    }
    public void add(Level level) {
        levels.add(level);
    }


    public List<Level> getAll() {
        return levels;
    }


    public void delete(Level level) {
        levels.remove(level);
    }
}
