package Homework.fourteenth;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameTest {
    private List<Game> games;

    public GameTest() {
        games = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        games.add(new Game("One", 2019));
        games.add(new Game("Two", 2012));
        games.add(new Game("Kiril", 2015));
    }

    public void add(Game game) {
        games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }

    public void deleteGame(Game game) {
        games.remove(game);
    }
}
