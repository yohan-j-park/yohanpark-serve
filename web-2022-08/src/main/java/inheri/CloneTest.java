package inheri;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Member a = new Member(10);
        Member b = a;
        
        System.out.println("수정 전...");
        System.out.println(a.su + "," + b.su);
        
        a.su = 100;
        System.out.println("수정 후...");
        System.out.println(a.su + "," + b.su);
        
        b.su = 300;
        System.out.println("b의 값을 변경...");
        System.out.println(a.su + "," + b.su);
        System.out.println("-----↑↑↑주소값만 복사(얕은 복사)------");
        
        Member c = (Member)a.clone(); // 깊은 복사
        c.su = 400;
        System.out.println(a.su + "," + c.su);
        
        
    }
}
