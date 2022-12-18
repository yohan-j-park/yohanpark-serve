package array;

public class Student {
    String name;   // 필드
    int score;     // 필드
    double weight; //필드
    
    Student(String name, int score, double weight){ //로컬 변수
        this.name   = name;   // 필드, 로컬변수 (필드명과 로컬변수명이 같을 때 this.를 붙이면 필드명을 뜻한다)
        this.score  = score;
        this.weight = weight;
    // Student의 생성자의 매개변수를 사용하여 각각의 값을 필드에 저장한 후 출력
    }

    @Override // 어노테이션
    public String toString() {
        String str =  "name : "   + this.name  + "\n"
                    + "score : "  + this.score + "\n"
                    + "weight : " + this.weight;
        return str;
    }
}