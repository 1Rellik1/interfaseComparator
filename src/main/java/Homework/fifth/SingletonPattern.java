package Homework.fifth;

public class SingletonPattern {
    private SingletonPattern instance;
    public synchronized SingletonPattern getInstance() {
        if(instance == null) {
            instance = new SingletonPattern();
            return instance;
        }
        return instance;
    }

}
