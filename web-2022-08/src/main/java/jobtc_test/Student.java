package jobtc_test;

public class Student implements Human {

    
    @Override
    public void select() {
        System.out.println("재정의된 Student.select()입니다.");
    }
    @Override
    public void update() {
        System.out.println("재정의된 Student.update()입니다.");
    }
    @Override
    public void delete() {
        System.out.println("재정의된 Student.delete()입니다.");
    }
    @Override
    public void insert() {
        System.out.println("재정의된 Student.insert()입니다.");
    }
}
