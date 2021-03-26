package Homework.twentysecond.Services;



import Homework.twentysecond.Classes.Game;
import Homework.twentysecond.Classes.Level;
import Homework.twentysecond.Controllers.GameController;
import Homework.twentysecond.Controllers.LevelController;
import Homework.twentysecond.ScheduleMXBean;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class Schedule implements ScheduleMXBean {
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
        List <Level> levels= levelController.getAll();
        List <Game> games= gameController.getAll();
        for (int i=0; i< games.size();i++) {
            File game = new File("D:\\java projects\\interfaseComparator\\src\\main\\java\\smth");
            FileWriter writer = new FileWriter(game, false);
            writer.write(games.get(i).toString());
        }

        for (int i=0; i< levels.size();i++) {
            File level = new File("D:\\java projects\\interfaseComparator\\src\\main\\java\\smth");
            FileWriter writer = new FileWriter(level, false);
            writer.write(levels.get(i).toString());
        }
    }
}
