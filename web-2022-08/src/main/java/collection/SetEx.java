package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetEx {
    
    public void test1() {
        Set<String> hs = new HashSet<String>();
        // 추가
        hs.add("kim");
        hs.add("hong");
        hs.add("park");
        hs.add("nam");
        
        // 수정(remove -> add)
        hs.remove("park");
        hs.add("gang");
        System.out.println(hs.toString());
        
        // 조회(순차적으로 접근하는 방법) (Set -> Iterator -> hasNext, Next)
        Iterator<String> iter = hs.iterator();
        while(iter.hasNext()) {
            String s = iter.next();
            System.out.println(s);
        }
    }
    
    public void test2() {   //중복 값 제거 후 출력
        Integer[] a = {1,2,3,4,5,6,7,8,9};
        Integer[] b = {6,7,8,9,234,46,42234};
        
        List<Integer> aa = new ArrayList<Integer>(Arrays.asList(a));
        List<Integer> bb = new ArrayList<Integer>(Arrays.asList(b));
        
        // 합집합
        System.out.println("합치기 전aa: " + aa);
        System.out.println("합치기 전bb: " + bb);
        aa.addAll(bb);
        System.out.println("합친 후aa: " + aa);
        
        // 중복 제거
        Set<Integer>set = new HashSet<Integer>();
        
        set.addAll(aa);
        System.out.println("set: " + set.toString());

    }
    public void test3() {   //요소의 개수를 카운팅
        Integer[] su = {1,1,1,1,2,3,3,4,4,4,5,5,6,6,6,7,7,8,9,9,9,9,9};
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(su));     //55~56행: 37,38행을 풀어서 쓴 것
        
        Set<Integer> set = new HashSet(list);
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            Integer i = iter.next();
            int count = Collections.frequency(list, i);     //reduce랑 비슷한 역할
            System.out.printf("%d - %d\n", i, count);
        }
    }
    
    public void test4() {   
        // score의 값을 사용하여 각 학점대의 명 수를 출력
        // ex) 90~ : 1명 / 80~ : 1명
        Integer[] score = {66,77,55,44,33,88,99,77,44};
        List<Integer> list = new ArrayList<Integer>();
        for(Integer i : score) {
            list.add(Math.floorDiv(i, 10));
        }
        
        Set<Integer> set = new HashSet<Integer>(list);
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            Integer i = iter.next();
            int count = Collections.frequency(list, i);
            System.out.printf("%d~ : %d명\n" , (i*10), count);
            
//                    if(i>=90) {
//                        System.out.println("90점대: " + count);
//                    }
//                    else if(i>=80) {
//                        System.out.println("80점대: " + count);
//                    }
//                    else if(i>=70) {
//                        System.out.println("70점대: " + count);
//                    }
//                    else if(i>=60) {
//                        System.out.println("60점대: " + count);
//                    }
//                    else System.out.println("60점 미만: " + count);

        }
            
        
    }
    
    public static void main(String[] args) {
        new SetEx().test4();
    }
}