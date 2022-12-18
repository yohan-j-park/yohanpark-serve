package exception_ex;

public class TryTest {
    
    int a(){
        String s = "ㅁㅁㅁ";
        try {
            int i = Integer.parseInt(s);   
            System.out.println(i);
        }catch(NumberFormatException ex){
            System.out.println("숫자만 입력하세요");            
        }finally {
            System.out.println("무조건 실행");
        }
        return 10;
    }
    void b() {      //첨자 오류에 대한 예
        String[] ary = {"a","b","c"};
        for(int i=0; i<=3; i++) {
            try {
                System.out.println(ary[i]);                
            }catch(ArrayIndexOutOfBoundsException ex) {     //어떤 종류의 Exception인지 모를땐 그냥 Exception만 써도 됨
                System.out.println("배열의 크기를 확인해 주세요");
            }
        }
        
    }
    void c() throws Exception {
        int x,y;
        try {
            x=20;
            y=x/0;
            System.out.println(x+y);
        }catch(Exception e) {
            System.out.println("연산식에 오류가 있습니다.");
        }
    }
    
    void d() { // 임의로 예외 발생 시키기
    try {    
        throw new Exception("오류남");
//      System.out.println("이 곳은 실행되지 않음"); ->오류남
    }catch(Exception ex) {
        System.out.println(ex.getMessage());
    }
  }
    void e() { //null오류
        String name = null;
        try {
            System.out.println(name.equals("abc"));            
        }catch(NullPointerException ex) {
            System.out.println("NullPointerException..");
        }
        
    }
    

    public static void main(String[] args) {
        try {
            new TryTest().c();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
