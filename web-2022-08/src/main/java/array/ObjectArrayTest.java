package array;

public class ObjectArrayTest {
    void memberTest() {
        //객체형 배열을 사용하려면..?
        // 1) 배열 선언
        Member[] m = new Member[5]; // 5칸 전부 Null값임.
        // 2) 배열 요소에 객체 생성 후 대입
        for(int i=0; i<m.length; i++) {
            m[i] = new Member();
        }
        
        // 3) 사용
        for(int i=0; i<m.length; i++) {
        m[i].name="kim"+i;
        m[i].address="서울"+i;
        m[i].tel="kim"+i;
    }
        for (int i=0; i<m.length; i++) {
            System.out.println(m[i].name);
            System.out.println(m[i].address);
            System.out.println(m[i].tel);
            System.out.println("-----------------");
        }
    }
        public static void main(String[] args) {
            ObjectArrayTest ot = new ObjectArrayTest();
            ot.memberTest();
        }
}
