package Homework.twentyfirst.Services;



import Homework.twentyfirst.Classes.Game;
import Homework.twentyfirst.Classes.Level;
import Homework.twentyfirst.Interfaces.LevelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class LevelService {
    @Autowired
    private final LevelRepository levelRepository;

    public LevelService(LevelRepository levelRepository) { this.levelRepository = levelRepository; }

    public List<Level> getLevels() {
        return levelRepository.findAll();
    }


    public void deleteLevel(UUID id) {
        levelRepository.deleteById(id);
    }

    public List<Level> getByName(String name) { return levelRepository.findAllByName(name); }

    public List<Level> getByCmp(String complexity) {
        return levelRepository.findAllByComplexity(complexity);
    }
    public Game getGameByLevel(UUID id){
        return levelRepository.findById(id).getGame();
    }
}
