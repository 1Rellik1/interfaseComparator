package Homework.twelfth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TwelfthMain {
    private final Master master;

    @Autowired
    public TwelfthMain(Master master) {
        this.master = master;
    }

    public static void main(String[] args) throws Exception {
        String[] l;
        l = new String[2];
        l[1]="ab";
        l[0]="ad";
        SpringApplication.run(TwelfthMain.class,l);
    }
}
