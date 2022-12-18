package iostream;

import java.io.Serializable;
import java.util.Vector;


public class Data implements Serializable{      // 직렬화
    public static long serialVerionUID = 100L;      
    //인식표, 한 번 설정되면 초기화가 되지 않도록 static을 사용해야함
    //서로 다른 컴퓨터에서 작업해도 같은 객체라고 인식하기 하기 위함
    
    String id, mName, addr, phone;
    int point;
    
    public Data() {}
    public Data(String id, String mName, String addr, String phone, int point) {
        this.id = id;
        this.mName = mName;
        this.addr = addr;
        this.phone = phone;
        this.point = point;
    }
    // if crud 하려면 hashcode equals 재정의
    // JTable의 데이터 속성이 Vector<vector>이기 때문에
    public Vector getVector() {
        Vector v = new Vector();
            v.add(id);
            v.add(mName);
            v.add(addr);
            v.add(phone);
            v.add(point);
            
            return v;
        
    }

    @Override
    public String toString() {
        String temp = "\n--------------------"
                      +"\n id    : "  + this.id
                      +"\n name  : "  + this.mName
                      +"\n addr  : "  + this.addr
                      +"\n phone : "  + this.phone
                      +"\n point : "  + this.point;
        return temp;
                    
    }

// 객체의 동등비교: hashCode값도 같고 equals도 같으면 동등객체

    @Override
    public int hashCode() {     //기본: 패키지명.클래스명@자신의 hashCode => 객체마다 전부 다름. (객체동등비교하기 위해 재정의)
        
        return this.id.hashCode();  //여기서 return하는 id는 고정문자열이다.
    }
    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if(obj instanceof Data) {   
            Data d = (Data)obj;
            b = d.getId().equals(this.id);
        }
        return b;
    }
    public String getId() {
        return id;
    }



    public String getmName() {
        return mName;
    }



    public String getAddr() {
        return addr;
    }



    public String getPhone() {
        return phone;
    }



    public int getPoint() {
        return point;
    }



    public void setId(String id) {
        this.id = id;
    }



    public void setmName(String mName) {
        this.mName = mName;
    }



    public void setAddr(String addr) {
        this.addr = addr;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public void setPoint(int point) {
        this.point = point;
    }
    
    
    
    
    
}
