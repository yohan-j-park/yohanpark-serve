package array;

public class StudentArrayTest {
    void arrayTest/* 생성자 */() { // 같은 패키지에서는 접근할 수 있다.
        String[] name = {"kim", "lee", "park", "choi", "nam"};
        int[] score = {55,66,77,88,99};
        double[] weight = {88,99,77,66,55};
        
        // 1) Student type의 배열을 선언
        Student[] std = new Student[5];
        
        // 2) 배열에 student 객체 생성 후 대입
        for(int i=0; i<std.length; i++) {
            std[i] = new Student(name[i], score[i], weight[i]); // Student()모양의 생성자가 없다.
        }
        for(int i=0; i<std.length; i++) {
            System.out.println(std[i]);
            System.out.println("-".repeat(20));
        }
        // park씨의 성적과 몸무게를 각각 100,70으로 수정
        int k = -1; // 검색 된 위치
        for(int i=0; i<std.length; i++) {
            if (std[i].name.equals("nam")) { //문자열은 관계연산자로 비교하지 않는다
                k=i;
                break;
            }
        }
        if(k>-1) {
           
        System.out.println("수정 전 : ");
        System.out.println(std[k]);
        std[k].score = 100;
        std[k].weight = 70d;
        System.out.println("수정 후 : ");
        System.out.println(std[k]);
      } else {
          System.out.println("찾는 데이터가 없습니다.");
      }
    }
    public static void main(String[] args) {
        StudentArrayTest st = new StudentArrayTest();
        st.arrayTest();
    }
}
