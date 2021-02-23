package Homework.third;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Thirdmain {

    public static void main(String[] args) {
        Thread thread1 =  new MyThread("first");
        Thread thread2 =  new MyThread("second");
        Thread thread3 =  new MyThread("third");
        thread1.start();
        thread2.start();
        thread3.start();
    }
    public static class MyThread extends Thread {
        MyThread(String name){ this.setName(name);}
        ArrayList list = new ArrayList<Integer>(1);
        Semaphore sem = new Semaphore(1);
        public void run() {
            list.add(1);
            try {
                sem.acquire();
                System.out.println(Thread.currentThread().getName() + " ожидает разрешение");
                for (int i = 1; i < 5; i++) {
                    list.add(1, 1);
                    System.out.println(list.get(1));
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + " освобождает разрешение");
            sem.release();
        }
    }
}

