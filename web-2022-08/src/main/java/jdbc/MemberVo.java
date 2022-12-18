package jdbc;

public class MemberVo {     // 한 건의 데이터를 저장하는 공간
    String id, irum, gender, phone, mDate, photo;
    
    public String getmDate() {
        return mDate;
    }
    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
    public MemberVo() {   
        
    }
    public MemberVo(String id, String irum, String gender, 
                    String phone, String photo) {
        this.id = id;
        this.irum = irum;
        this.gender = gender;
        this.phone = phone;
        this.photo = photo;
     
     
    }
    public String getId() {
        return id;
    }
    public String getIrum() {
        return irum;
    }
    public String getGender() {
        return gender;
    }
    public String getPhone() {
        return phone;
    }
    public String getPhoto() {
        return photo;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setIrum(String irum) {
        this.irum = irum;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    
}
