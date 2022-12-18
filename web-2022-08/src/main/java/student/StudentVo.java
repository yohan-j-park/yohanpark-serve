package student;

import crypto.AES;

public class StudentVo {    
    String id;
    String name;
    String phone;
    String pwd;
    String address;
    String address2;
    String gender;
    String email;
    String zipcode;
    
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public String getPwd() {
        return pwd;
    }
    public String getAddress() {
        return address;
    }
    public String getAddress2() {
        return address2;
    }
    public String getGender() {
        return gender;
    }
    public String getEmail() {
        return email;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setPwd(String pwd) {
//        AES aes = new AES();
//        this.pwd = aes.encrypt(pwd);
        this.pwd = pwd;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setAddress2(String address2) {
        this.address2 = address2;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    
}
