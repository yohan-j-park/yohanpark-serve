package array;

import java.util.Arrays;

public class ObjectArraySort {
    
    public static void main(String[] args) {
       Data2[] a = new Data2[3];
       a[0] = new Data2("park", 90);
       a[1] = new Data2("lee" , 95);
       a[2] = new Data2("kim" , 80);
       
       Arrays.sort(a);
       System.out.println(Arrays.toString(a));
   }
}
