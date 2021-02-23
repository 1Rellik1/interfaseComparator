package Homework.fourth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Smth  {
    public void dosmth() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.submit(new Runnable() {
                public void run() {
                    Thread.currentThread().setName(Integer.toString(finalI));
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
