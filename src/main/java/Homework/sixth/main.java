package Homework.sixth;

import Homework.sixth.Builder.GoodClass;
import Homework.sixth.prototype.Circle;

public class main {
    public static void main(String args[]) {
        GoodClass goodClass = new GoodClass.Builder(40, 20)
                .optFieldOne(2)
                .optFieldTwo(4)
                .optFieldThird(23)
                .optFieldFour(9)
                .buidl();
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";
        Circle anotherCircle = (Circle) circle.clone();
    }
}
