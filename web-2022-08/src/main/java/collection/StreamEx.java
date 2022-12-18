package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamEx {
    
    public StreamEx() {
        // List
        String[] str = {"강아지", "송아지", "망아지", "호랑이", "고양이"};
        List<String> list = new ArrayList<String>(Arrays.asList(str));
        Stream<String> stream = list.stream();
        stream.forEach(x -> System.out.println(x));
        System.out.println("-".repeat(20));
        
        list.forEach(x -> System.out.println(x));
        System.out.println("-".repeat(20));
        
        //Array
        stream = Arrays.stream(str);
        stream.forEach(abc -> System.out.println(abc));
        System.out.println("-".repeat(20));
        
        //Map<K,V>
        Map<String, String> map = new HashMap<String, String>();
        map.put("aaaa", "kim");
        map.put("bbbb", "lee");
        map.put("cccc", "park");
        map.put("dddd", "hong");
        
//        map.forEach((key , value) -> { });      <- 원형
        map.forEach((key, value) -> {
            System.out.printf("%s : %s \n", key, value);
            System.out.println("-".repeat(20));
        } );
        
        //map()
        List<String> list1 = Arrays.asList("abc","ABC","aBC", "abC");
        Stream stream1 = list1.stream().map(x ->(x.toUpperCase()));
        stream1.forEach(x-> System.out.print(x + ", "));
        System.out.println("-".repeat(20));
        
        // distinct()
        List<Integer> list2 = Arrays.asList(1,2,3,4,5,6,3,6);
        Stream stream2 = list2.stream();
        stream2.distinct().forEach(x -> System.out.println(x));
        System.out.println("-".repeat(20));
        
        // filter()
        List<Integer> list3 = Arrays.asList(1,2,3,4,3,4,5,6);
        Stream stream3 = list3.stream().filter(x -> x>4);
        stream3.forEach(x -> System.out.print(x + " "));
        System.out.println("-".repeat(20));
        
        // sorted()
        List<Integer> list4 = Arrays.asList(6,5,8,9,4,3,2,1,7);
        Stream stream4 = list4.stream().sorted();
        stream4.forEach(x -> System.out.println(x + " "));
        System.out.println("-".repeat(20));
        
        // match()
//            allMatch(): 모든 조건이 만족할 때 참
//            anyMatch(): 하나의 조건만 만족해도 참
//            noneMatch(): 모든 조건이 만족하지 않으면 참
        List<Integer> list5 = Arrays.asList(6,5,8,10,12,39,40,23,1);
        boolean b1 = list5.stream().allMatch(x -> x%2 == 0);
        System.out.println("모두 짝수인가?" + b1);
        System.out.println("-".repeat(20));
        
        Stream stream5 = list5.stream();
        boolean b2 = list5.stream().anyMatch(x -> x<10);
        System.out.println("하나 이상의 수가 10보다 작은가? : " + b2);
        System.out.println("-".repeat(20));
       
        
        // sum(), count(), average(), max(), min()
        int[] su = {1,2,3,4,5};
        long hap = Arrays.stream(su).sum();
        System.out.println("hap : " + hap);
        hap = Arrays.stream(su).filter(x -> x<4).sum();
        System.out.println("hap2 : " + hap);
        System.out.println("-".repeat(20));
        
        long cnt = Arrays.stream(su).count();
        System.out.println("cnt : " + cnt);
        cnt = Arrays.stream(su).filter(x -> x<4).count();
        System.out.println("cnt2 : " + cnt);
        System.out.println("-".repeat(20));
              
        // reduce()
        Stream<Integer> stream6 = Stream.of(1,2,3,4,5);
        Optional<Integer> opt = stream6.reduce((x,y) -> x+y);
        opt.ifPresent(s -> System.out.println(s));
        System.out.println("-".repeat(20));
        
        // collect()
        Integer[] su2 = {1,2,3,4,5,6,7,8,9};
        List<Integer> list7 = Arrays.stream(su2).filter(x -> x>5)
                .collect(Collectors.toList());
        list.stream().forEach(x -> System.out.println(x));
        System.out.println("-".repeat(20));
        
    }
    
    public static void main(String[] args) {
        new StreamEx();
    }
}
