package Homework.fourth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Smth  {
    private int number_of_Threads;
    private ExecutorService service;
    public Smth(int n){
        number_of_Threads=n;
        service=Executors.newFixedThreadPool(number_of_Threads);
    }
    public void dosmth() {
        for (int i = 0; i < number_of_Threads; i++) {
                int finalI = i;
                service.submit(new Runnable() {
                    public void run() {
                        Thread.currentThread().setName(Integer.toString(finalI));
                        System.out.println(Thread.currentThread().getName());
                    }
            });
        }
    service.shutdown();
    }
}