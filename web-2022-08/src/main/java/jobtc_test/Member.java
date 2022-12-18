package jobtc_test;

public class Member implements Human{

    @Override
    public void select() {
        System.out.println("재정의된 Member.select()입니다.");
    }
    @Override
    public void update() {
        System.out.println("재정의된 Member.update()입니다.");

    }
    @Override
    public void delete() {
        System.out.println("재정의된 Member.delete()입니다.");

    }
    @Override
    public void insert() {
        System.out.println("재정의된 Member.insert()입니다.");

    }
}
