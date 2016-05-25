package methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class MethodReferenceDemo {

    public static void main(String[] args){

        List<Integer> myList = new ArrayList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        myList.forEach(i -> System.out.println(i));

        System.out.println("----------------------------------------");
        //pass method reference instead of Consumer
        myList.forEach(System.out::println);

        System.out.println("*----------------------------------------*");
        myList.forEach(MethodReferenceDemo::multiply);
        System.out.println("*----------------------------------------*");
    }

    public static Integer multiply(Integer i){
         i *= 2;
        System.out.println(i);
        return i;
    }
}
