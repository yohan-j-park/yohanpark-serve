package jobtc_test;

public class Test{
    public Human getHuman() {
        Human h = new Student();
        return h;
    }
    public void setStudent(Human human) {
        human.insert();
        human.select();
        human.update();
        human.delete();
    }
    
    public static void main(String[] args) {
        Student student = new Student();
        Test test = new Test();
        test.setStudent(student);
        /* 
         Test t = new Test();
         Human h = new Student();
         t.setStudent(h);
         * */
    }
}
