package Homework.twentythird.Services;



import Homework.twentythird.Classes.Game;
import Homework.twentythird.Classes.Level;
import Homework.twentythird.Controllers.GameController;
import Homework.twentythird.Controllers.LevelController;
import Homework.twentythird.Interfaces.GameRepository;
import Homework.twentythird.Interfaces.LevelRepository;
import Homework.twentythird.ScheduleMXBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class Schedule implements ScheduleMXBean {
    @Autowired
    private final GameRepository gameRepository;
    @Autowired
    private final LevelRepository levelRepository;

    public Schedule(GameRepository gameRepository, LevelRepository levelRepository) {
        this.gameRepository = gameRepository;
        this.levelRepository = levelRepository;
    }

    private Boolean isEmpty(final File file) {
        return (file.isDirectory() && (file.list().length > 0));
    }
    @ManagedOperation
    @Scheduled(cron = "0 0/30 * * * *")
    public void doScheduledTask() throws IOException {
        if(isEmpty(new File("D:\\java projects\\interfaseComparator\\src\\main\\java\\smth"))){
            for (File myFile : new File("D:\\java projects\\interfaseComparator\\src\\main\\java\\smth")
                    .listFiles()) {
                if (myFile.isFile()) myFile.delete();
            }
        }
        GameController gameController = new GameController();
        LevelController levelController = new LevelController();
        List <Level> levels= levelRepository.findAll();
        List <Game> games= gameRepository.findAll();
        for (int i=0; i< games.size();i++) {
            File game = new File("D:\\java projects\\interfaseComparator\\src\\main\\java\\smth\\game"+i+".txt");
            FileWriter writer = new FileWriter(game, false);
            writer.write(games.get(i).toString());
        }

        for (int i=0; i< levels.size();i++) {
            File level = new File("D:\\java projects\\interfaseComparator\\src\\main\\java\\smth\\level"+i+".txt");
            FileWriter writer = new FileWriter(level, false);
            writer.write(levels.get(i).toString());
        }
    }
}
