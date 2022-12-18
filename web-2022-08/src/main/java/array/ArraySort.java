package array;

import java.util.Arrays; // java.util.*;
import java.util.Collections;

public class ArraySort {
    
    public void test1() {
        int[] su= {3,4,3,2,4,76,7,87,56,54,3,3,2};
        System.out.println(Arrays.toString(su));
        Arrays.sort(su);
        System.out.println("정렬 후...");
        System.out.println(Arrays.toString(su)); // js는 sort를 하면 문자열취급을 했지만, java는 그렇지 않다.
    }
    public void test2() {
        int[] su= {3,4,3,2,4,76,7,87,56,54,3,3,2};
        Arrays.sort(su, 5, su.length);
        System.out.println(Arrays.toString(su));

    }
    public void test3() {
        Integer[] su= {3,4,3,2,4,76,7,87,56,54,3,3,2}; // int형의 객체 Integer
//        new Integer(3),new Integer(4),...
            Arrays.sort(su, Collections.reverseOrder());
            System.out.println(Arrays.toString(su));
    }
    public void test4() {
        // 배열을 5개씩 잘라 오름차 정렬 후 출력하시오.
        int[] su= {12,3,4,23,42,34,25,34,23546,334,6,3576,4746,74,635,4,234,134,234,2344536};
//        int[] su1 = new int[5];
//        int[] su2 = new int[5];
//        int[] su3 = new int[5];
//        int[] su4 = new int[5];
//        System.arraycopy(su,0,su1,0,5);
//        System.arraycopy(su,5,su2,0,5);
//        System.arraycopy(su,10,su3,0,5);
//        System.arraycopy(su,15,su4,0,5);
//        
//        Arrays.sort(su1); 
//        Arrays.sort(su2);
//        Arrays.sort(su3);
//        Arrays.sort(su4);
//        
//        System.out.println(Arrays.toString(su1));
//        System.out.println(Arrays.toString(su2));
//        System.out.println(Arrays.toString(su3));
//        System.out.println(Arrays.toString(su4));
        int[] temp = new int[5];
        for(int i=0; i<su.length; i=i+5) {
        System.arraycopy(su, i, temp, 0, 5);
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
        }
    }

    public ArraySort() {
        test1();
        test2();
        test3();
        test4();
    }
    public static void main(String[] args) {
        new ArraySort();
    }
}
