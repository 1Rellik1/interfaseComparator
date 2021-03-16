package Homework.sixth.absctract_fabricka;

public class VictorianChair implements Chair {
    public VictorianChair() {
        System.out.println("Викторианский стул у вас)");
    }

    @Override
    public void sit() {
            System.out.println("Вы сели на викторианский стул");
    }
}
