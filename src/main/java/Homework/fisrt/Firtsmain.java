package Homework.fisrt;

import java.util.Comparator;
import java.util.Scanner;


public class Firtsmain {
    public static void main(String args[]) {
        System.out.println("Введите размеры массивов через пробел");
        Scanner scanner = new Scanner(System.in);
        int k= scanner.nextInt();
        int k1 = scanner.nextInt();
        int[] a = new int[k];
        int[] b = new int [k1];
        Comparator<int[]> comparator = (a1, b1) -> {
            if (a1.length > b1.length) return 1;
            else if (a1.length == b1.length) return 0;
            else return -1;
        };
        if(comparator.compare(a,b)==1){
            System.out.println("Первый массив больше");
        } else if(comparator.compare(a,b)==0){
            System.out.println("Размеры массивов равны");
        }
        else System.out.println("Второй массив больше");
    }
}
