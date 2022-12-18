package interface_ex;

public class AfterAscMember implements MemberInterface {
    String irum;
    
    @Override
    public void setName(String name) {
        this.irum = name;
        
    }

    @Override
    public String GetName() {
        
        return this.irum;
    }


}
