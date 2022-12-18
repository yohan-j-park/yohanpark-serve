package array;
import java.util.Arrays;
public class ArrayTest4 {
    public ArrayTest4() {
        int[][] score = { {1,2,3}, {4,5,6}, {7,8,9} };

        prn(score); 
        prn(score[0]);
        prn(score[0][0]);
        tot(score);
        for(int r=0; r<score.length; r++) {
            hap(score[r]);            
        }
    }
    public void tot(int[][]s) {
        int sum = 0;
        int avg = 0;
        int cnt = 0; // 데이터의 개수
        for (int r=0; r<s.length; r++) {
            for(int c=0; c<s[r].length; c++) {
                sum += s[r][c];
                cnt++;
            }
        }
        System.out.println("sum: " + sum);
        System.out.println("avg: " + (sum/(double)cnt));
    }
    public void hap(int[]s) {
        int sum=0;
        double avg=0;
        for(int i=0; i<s.length; i++) {
           sum += s[i];
        }
        avg = sum/(double)s.length; // 계산 중인 데이터에 형변환을 시켜야 형변환이 된다. 전체 결과에 더블을 붙여봤자 이미 int형이라 소숫점이 짤린 상태이다.
        System.out.println("합계: " + sum);
        System.out.println("평균: " + avg);
        System.out.println("-----------------------");
    }
    public void prn(int[][]s) {
        int tot=0;
        int hap=0;
        double avg;
        System.out.println("2차원 배열 출력");
        for(int i=0; i<s.length; i++) {
           System.out.println(Arrays.toString(s[i])); 
        }
    }
    public void prn(int[]s) {
        System.out.println("1차원 배열 출력");
        System.out.println(Arrays.toString(s));
    }
    public void prn(int s) {
        System.out.println("정수형 배열 출력");
        System.out.println(s);
    }
    public static void main(String[] args) {
       new ArrayTest4();
    }
}

