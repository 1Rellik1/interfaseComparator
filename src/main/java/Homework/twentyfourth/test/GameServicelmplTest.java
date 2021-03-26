package Homework.twentyfourth.test;

import Homework.twentyfourth.Classes.Game;
import Homework.twentyfourth.Interfaces.GameRepository;
import Homework.twentyfourth.Interfaces.LevelRepository;
import Homework.twentyfourth.Services.GameService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class GameServicelmplTest {

    @Mock
    private GameRepository gameRepository;
    @Test
    public void getGame() {
        gameRepository=mock(GameRepository .class);
        Game game = new Game();
        game.setName("Vasya");
        Game game1 = new Game();
        game1.setName("Dima");
        Mockito.when(gameRepository.findAll()).thenReturn(List.of(game,game1));
        GameService userService = new GameService(gameRepository);
        Assertions.assertEquals(2, userService.getGames().size());
        Assertions.assertEquals("Vasya",
                userService.getGames().get(0).getName());
    }
}
