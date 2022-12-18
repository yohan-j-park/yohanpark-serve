package array;

import java.util.Arrays;

public class ArrayCopy {
    public void exam1() {
        //for문을 이용한 복사
        int[]a = {1,2,3,4,5};
        int[]b = new int[5];
        
       for(int i=0; i<a.length; i++) {
           b[i] = a[i];
           System.out.println(b[i]);
       }
       System.out.println("---------------------------");
    }
    public void exam2() {
        //System.arraycopy를 이용한 복사
        int[]a = {2,3,4,5};
        int[]b = new int[4];
        
        System.arraycopy(a,0,b,0,4);
        for(int i=0; i<b.length; i++) {
            System.out.println(b[i]);            
        }
        System.out.println("---------------------------");
    }
    public void exam3() {
        //clone을 이용한 복사
        int[] a = {7,8,9};
        int[] b = a.clone();
        for(int i=0; i<b.length; i++) {
            System.out.println(b[i]);            
        }
        System.out.println("---------------------------");
    }
    public ArrayCopy() {
       exam1();
       exam2();
       exam3();
    }
    public static void main(String[] args) {
        new ArrayCopy();
    }
}
