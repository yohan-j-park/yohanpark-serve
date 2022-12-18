package jdbc;

import java.sql.Connection;
import java.sql.CallableStatement;

public class InsertMemberCall {
    
    
    InsertMemberCall(){
        Connection conn = new DBConn("mydb").getConn();
        try {
            String sql = "{call InsertMember(?,?,?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setString(1, "ddd");
            cstmt.setString(2, "hong");
            cstmt.setString(3, "m");
            cstmt.setString(4, "010");
            cstmt.setString(5, "picture");
//            cstmt.registerOutParameter(6, java.sql.JDBCType.INTEGER);
            
            cstmt.executeQuery();
            
//            int cnt = cstmt.getInt(6);
//            if(cnt>0) conn.commit();
//            else      conn.rollback();
            
            cstmt.close();
            conn.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new InsertMemberCall();
    }
}
