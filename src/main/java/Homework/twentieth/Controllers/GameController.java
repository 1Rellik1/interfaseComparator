package Homework.twentieth.Controllers;

import Homework.twentieth.Classes.Game;
import Homework.twentieth.Services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    private GameService test;

    @GetMapping("/games")
    public List<Game> getAll() {
        return test.getGames();
    }

    @DeleteMapping("/game/{id}")
    public void delete(@PathVariable UUID id) {
        test.deleteGame(id);
    }

    @GetMapping("/getGameByName/{name}")
    public List<Game> getByName(@PathVariable String name){
        return test.getByName(name);
    }

    @GetMapping("/getByCreationYear/{year}")
    public List<Game> getByCreationYear(@PathVariable int year){
        return test.getByYear(year);
    }
}

