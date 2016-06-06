package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * Created by salonivithalani on 5/25/16.
 */
public class StreamApiDemo {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Function<Integer, Integer> func = i -> i*2;

//        BinaryOperator<Integer> binOp = new BinaryOperator<Integer>() {
//            @Override
//            public Integer apply(Integer i1, Integer i2) {
//                return i1 += i2;
//            }
//        };

        BinaryOperator<Integer> binOp = (Integer i1, Integer i2) -> {
            return i1 += i2;
        };

//        BiFunction<Integer, Double, Long> biFunc = new BiFunction<Integer, Double, Long>() {
//            @Override
//            public Long apply(Integer integer, Double aDouble) {
//                return null;
//            }
//        };

        BiFunction<Integer, String, Integer> biFunc = (Integer s, String in) -> {
            return null;
        };

        list.stream().map(func).forEach(System.out::println);
        list.stream().forEach(System.out::println);

        Integer i = list.stream().reduce(0, (i1, i2) -> {
            return i1 += i2;
        });
        System.out.println(i);

        //Strings
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        List<String> strings1 = new ArrayList<String>();
        strings1.add("1");
        strings1.add("2");
        strings1.add("3");
        strings1.add("4");
        strings1.add("5");


        String del = "* ";

        Stream<String> stringStream = strings.stream().map(s -> "\n" + s + " he");
        String res2 = stringStream.reduce("", (result, val)->result + val + del);

        System.out.println(res2);

        list.stream().reduce(0, (result,value)->Integer.sum(result,value));
        list.stream().reduce(0, Integer::sum);

        List<Integer> intList = Arrays.asList(10,20,35,42,55,64);
        intList = Arrays.asList(22,33,44);

        int res = intList.stream().reduce(0, (result,value) -> {

            if(value%5 == 0) return result + value;

            return result;
        });

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%5==0;
            }
        };

        res = intList.stream().filter(integer -> integer%5==0).reduce(0, Integer::sum);
        res = intList.stream().filter(integer -> integer%5==0).findFirst().orElse(0);
        res = intList.stream().filter(integer -> integer%5==0).findFirst().orElseGet(()->90);
//        res = intList.stream().filter(integer -> integer%5==0).findFirst().orElseThrow(() -> new NoSuchElementException());

        System.out.println(res);

    }
}
