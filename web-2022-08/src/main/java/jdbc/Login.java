package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import crypto.AES;

public class Login {
    public boolean login(String mId, String pwd) {
        AES aes = new AES();
        
        pwd=aes.encrypt(pwd);
        
        boolean b = false;
        
        try {
        Connection conn = new DBConn("mydb").getConn();
        String sql = "select * from student where id = ? and pwd=?"; 
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, mId);
        ps.setString(2, pwd);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            b=true;
        }
        ps.close();
        conn.close();
        
        }catch(Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
