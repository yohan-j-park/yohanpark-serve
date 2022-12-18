package inheri;

public class Child extends ParentClass implements FatherInter{
    Child(){
        prn();
    }
    
    public static void main(String[] args) {
        Child c = new Child();
        c.age();
    }

    @Override
    public void age() {
        System.out.println("18세");
        
    }
}
