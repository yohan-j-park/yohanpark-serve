package jsp;

public class BeanTestVo {
    String irum;        // jsp form tag 안에 있는 name=? 값과 똑같은 변수를 사용해야 한다.
    String address;
    
    public String getIrum() {return irum;}
    public String getAddress() {return address;}
    public void setIrum(String irum) {this.irum = irum;}
    public void setAddress(String address) {this.address = address;}
    
}
