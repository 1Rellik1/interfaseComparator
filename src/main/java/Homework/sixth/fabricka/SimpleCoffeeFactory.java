package Homework.sixth.fabricka;

public class SimpleCoffeeFactory {
    public Coffee createCoffee (CoffeeType type) {
        Coffee coffee = null;

        switch (type) {
            case AMERICANO:
                coffee = new Americano();
                break;

            case CAPPUCCINO:
                coffee = new Cappuccino();
                break;
        }

        return coffee;
    }
}
