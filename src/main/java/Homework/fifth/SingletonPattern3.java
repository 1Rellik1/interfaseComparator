package Homework.fifth;

public class SingletonPattern3 {
    private static volatile SingletonPattern3 instance;

    public String value;

    private SingletonPattern3(String value) {
        this.value = value;
    }

    public static SingletonPattern3 getInstance(String value) {
        SingletonPattern3 result = instance;
        if (result != null) {
            return result;
        }
        synchronized(SingletonPattern3.class) {
            if (instance == null) {
                instance = new SingletonPattern3(value);
            }
            return instance;
        }
    }
}
