package Homework;

import Homework.eighth.Template_Method.Facebook;
import Homework.eighth.Template_Method.Network;

public class main {
    public static void main(String[] args) {
        Facebook facebook = new Facebook("Rellik", "123321");
        Boolean logedin;
        logedin = facebook.logIn("Rellik", "123321");
    }
}
