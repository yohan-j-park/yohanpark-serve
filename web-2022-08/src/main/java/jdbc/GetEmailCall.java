package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class GetEmailCall {
    
    GetEmailCall(){
        Connection conn = new DBConn().getConn();
        try {
            conn.setAutoCommit(false);
            
            String sql = "{call GetEmail(?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            ResultSet rs = cstmt.executeQuery(sql);
            
            cstmt.setString(1, "%A%");
            cstmt.setString(2, "%B%");
            cstmt.registerOutParameter(3, java.sql.JDBCType.LONGVARCHAR);
            
            cstmt.executeQuery();
            String e = cstmt.getString(3);
            
            System.out.println(e);
            
            cstmt.close();
            conn.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new GetEmailCall();
    }
}
