package Homework.sixth.absctract_fabricka;

public class MagicChair implements Chair{
    public MagicChair() {
        System.out.println("Магический стул у вас)");
    }

    @Override
    public void sit() {
        System.out.println("Вы сели на магический стул");
    }
}
