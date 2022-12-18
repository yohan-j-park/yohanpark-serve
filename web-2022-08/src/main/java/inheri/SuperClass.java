package inheri;

public class SuperClass {
    private String privateField = "나만 쓸 수 있는 필드";
    public String publicField =   "아무나 쓸 수 있는 필드";
    
    SuperClass(){
        System.out.println(privateField);
        System.out.println(publicField);
        privateMethod();
        publicMethod();
    }
    
    private void privateMethod() {
        System.out.println("나만 쓸 수 있는 메소드");
    }
    public void publicMethod() {
        System.out.println("아무나 쓸 수 있는 메소드");
    }
    
    public static void main(String[] args) {
        SuperClass c = new SuperClass();
    }
}
