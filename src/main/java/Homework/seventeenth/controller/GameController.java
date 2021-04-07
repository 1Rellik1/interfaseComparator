package Homework.seventeenth.controller;

import Homework.seventeenth.Entities.Game;
import Homework.seventeenth.GameTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    private GameTest test;

    @PostMapping("/game")
    public void post(@RequestBody Game game) {
        test.addGame(game);
    }

    @GetMapping("/games")
    public List<Game> getAll() {
        return test.getGames();
    }

    @DeleteMapping("/deletegame")
    public void delete(@PathVariable Game game) {
        test.delete(game);
    }

    @GetMapping("/getFilteredByName")
    public List<Game> getFilteredByName(){
        return test.getByName();
    }

    @GetMapping("/getFilteredByYear")
    public List<Game> getFilteredByLastName(){
        return test.getByYear();
    }


    @DeleteMapping("/game/{id}")
    public void delete(@PathVariable UUID id) {
        test.deleteGame(id);
    }


}
