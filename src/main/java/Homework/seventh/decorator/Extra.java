package Homework.seventh.decorator;

public abstract class Extra implements Order {

    protected Order order;
    protected String label;
    protected double price;

    public Extra(String label, double price, Order order) {

        this.label = label;
        this.price = price;
        this.order = order;

    }

    // Цена может оказаться основной проблемой.
    // так что поручим это конкретной реализации

    public abstract double getPrice();

    // Стандартной маркировки должно быть достаточно

    public String getLabel() {

        return order.getLabel() + ", " + this.label;
    }

}
