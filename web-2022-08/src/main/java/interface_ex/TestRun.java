package interface_ex;

public class TestRun {
    public static void main(String[] args) {
        Member m = new Member();
        AscMember am = new AscMember();
        
        Main main = new Main(m);
        Main main2 = new Main(am);
        
        MemberInterface mf1 = new AfterMember();
        MemberInterface mf2 = new AfterAscMember();
        
        Main main3 = new Main(mf1);
        Main main4 = new Main(mf2);
    }
}
