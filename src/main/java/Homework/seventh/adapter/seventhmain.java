package Homework.seventh.adapter;

public class seventhmain {
    public static void main(String[] args) {

        USB cardReader = new CardReader(new MemoryCard());
        cardReader.connectWithUsbCable();

    }
}
