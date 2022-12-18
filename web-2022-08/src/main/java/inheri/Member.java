package inheri;

public class Member implements Cloneable {
    int su;
    public Member(int s) {
        this.su = s;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException{
        Object o = super.clone();
        return o;
    }
}
