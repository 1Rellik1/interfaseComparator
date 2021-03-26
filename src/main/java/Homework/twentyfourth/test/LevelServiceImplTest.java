package Homework.twentyfourth.test;

import Homework.twentyfourth.Classes.Game;
import Homework.twentyfourth.Classes.Level;

import Homework.twentyfourth.Interfaces.LevelRepository;

import Homework.twentyfourth.Services.LevelService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class LevelServiceImplTest {
    @Mock
    private LevelRepository levelRepository;

    @Test
    public void getGame() {
        levelRepository=mock(LevelRepository.class);
        Level level = new Level();
        level.setName("Vasya");
        Level level1 = new Level();
        level1.setName("Dima");
        Mockito.when(levelRepository.findAll()).thenReturn(List.of(level,level1));
        LevelService userService = new LevelService(levelRepository);
        Assertions.assertEquals(2, userService.getLevels().size());
        Assertions.assertEquals("Vasya",
                userService.getLevels().get(0).getName());
    }
}
