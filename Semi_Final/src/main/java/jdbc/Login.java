package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Login {
   
   DBConn Connection;
   
   public String login(String mId, String pwd) {
      System.out.println(mId);
      String b = null;
      try {
         Connection conn = new DBConn("operation_management").getConn();
         String sql = "select * from login where binary MID = ? AND PWD = ?";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, mId);
         ps.setString(2, pwd);

         ResultSet rs = ps.executeQuery();
         if(rs.next()) {
            b = (String)rs.getString("Access_level");
          }
          
         ps.close();
         conn.close();
         
      }catch(Exception ex) {
         ex.printStackTrace();
      }
      System.out.println(b);
      return b;
   }
}
