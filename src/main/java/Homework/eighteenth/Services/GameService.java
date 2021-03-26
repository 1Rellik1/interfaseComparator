package Homework.eighteenth.Services;

import Homework.eighteenth.Classes.Game;
import Homework.eighteenth.Classes.Level;
import Homework.eighteenth.Interfaces.GameRepository;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getGames() {
        return gameRepository.findAll();
    }


    public void deleteGame(UUID id) {
        gameRepository.deleteById(id);
    }

    public List<Game> getByName(String name) {
        return gameRepository.findAllByName(name);
    }

    public List<Game> getByYear(int creationYear) {
        return gameRepository.findAllByCreationYear(creationYear);
    }
}
