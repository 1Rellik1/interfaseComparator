package Homework.seventh.decorator;



public class DoubleExtra extends Extra {

    public DoubleExtra(String label, double price, Order order) {

        super(label, price, order);

    }

    public double getPrice() {

        return (this.price * 2) + order.getPrice();

    }

    public String getLabel() {

        return order.getLabel() + ", Double " + this.label;

    }

}
