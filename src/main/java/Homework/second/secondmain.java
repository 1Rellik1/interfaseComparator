package Homework.second;

import java.util.*;
import java.util.stream.Stream;

public class secondmain {
    public static void main(String args[]) {
        List people = new ArrayList<Human>();
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<5; i++){
            Human human=new Human();
            Random random = new Random();
            human.setAge(1+random.nextInt(100));
            human.setFirstName(/*scanner.nextLine()*/ "a");
            people.add(human);
        }

        Stream <Human> stream = people.stream();
        stream.filter(human -> human.getAge() > 20)
                .peek(human -> System.out.println(human.getAge()+"  "+human.getFirstName()))
                .sorted(Comparator.comparing(human -> (int)(human.getFirstName().charAt(human.getFirstName().length()-1))))
                .peek(human -> System.out.println(human.getAge()+"  "+human.getFirstName()))
                .forEach(human ->{
                    human.setAge(human.getAge()+3);
                    System.out.println(human.getAge()+"  "+human.getFirstName());
                });
        System.out.println();
        stream = people.stream();
        ArrayList age = new ArrayList<Integer>();
        stream.forEach(human -> age.add(human.getAge()));
        int k= 0;
        for (int i=0 ;i< age.size();i++){
            int k1= (int) age.get(i);
            k=k+k1;
        }
        stream = people.stream();
        System.out.println(k/stream.count());
    }
}
