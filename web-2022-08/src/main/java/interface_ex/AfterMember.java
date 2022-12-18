package interface_ex;

public class AfterMember implements MemberInterface{
    
    String abc;

    @Override
    public void setName(String name) {
       this.abc = name;
        
    }

    @Override
    public String GetName() {
        // TODO Auto-generated method stub
        return this.abc;
    }
   
}
