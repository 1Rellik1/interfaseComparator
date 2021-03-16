package Homework.sixth.absctract_fabricka;

public class VictorianChairFabrika implements Fabrika {


    @Override
    public Chair createChair() {
        return new VictorianChair();
    }
}
