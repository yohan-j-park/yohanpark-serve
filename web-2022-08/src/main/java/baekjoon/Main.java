package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        int N = input.nextInt();
        
        int[] arr = new int[5];
        int sum = 0;
        for (int i=0; i<5; i++) {
            arr[i] = input.nextInt();
        }
        
        Arrays.sort(arr);
        
        System.out.println(arr[2]);
        
        for (int i=0; i<N; i++) {
            sum += arr[i];
        }
        System.out.println(sum/5);
    }

}