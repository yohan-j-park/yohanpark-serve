package inheri;

public class ChildClass extends SuperClass {
    ChildClass(){
        System.out.println(publicField);
        publicMethod();
    }
    public static void main(String[] args) {
        ChildClass cc = new ChildClass();
    }
}
