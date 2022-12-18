package my;

public class Test {
    
    public static void main(String[] args) {
        PrivateClass c = new PrivateClass();
        
//      c.score = 20; // PrivateClass 라는 클래스 필드에 정수형 변수 score의 접근제한자를 private로 선언해서 다른 클래스에선 사용할 수 없다.
        c.tot = 200; // 정수형 변수 tot는 접근제한자가 생략되어있어서 같은 패키지에서는 사용할 수 있다.
        c.hap(); // hap이라는 생성자의 접근제한자가 생략되어있어서 같은 패키지에서는 사용할 수 있다.
//      c.k();  // k라는 생성자의 접근제한자가 private라서 다른 패키지에서 사용 불가
    }
}
