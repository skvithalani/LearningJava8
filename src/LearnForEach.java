import java.util.*;
import java.util.function.Consumer;

/**
 * Created by salonivithalani on 5/7/16.
 */
public class LearnForEach {
    public static void main(String[] args){

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        //external loops - working from outside of collection
        System.out.println("------- traditional for loop---------");
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

        //advanced for loop - is also external loop
        System.out.println("------- advanced for loop---------");
        for(int i : list){
            System.out.println(i);
        }

        //java 8 for each loop - lambda expression
        System.out.println("------- lamda---------");
        list.forEach(
                i -> {
                        System.out.println(i);
                       }
        );   // So this is implementation of what interface - see below

        //Class
        class ConsumerImpl implements Consumer<Integer>{
            @Override
            public void accept(java.lang.Integer integer) {
                System.out.println("hehe " + integer);
            }
        }
        list.forEach(new ConsumerImpl());

        //Anonymous Class
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        list.forEach(integerConsumer);

        //Lamda expression for Consumer Interface
        Consumer<Integer> consumer = i -> System.out.println(i);
        list.forEach(consumer);

        //Anonymous lamda expression for Consumer Interface
        list.forEach(integer -> System.out.println("actual" + integer));

    }
}
