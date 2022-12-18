package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ProcedureCall {
    
    ProcedureCall(){
        Connection conn = new DBConn().getConn();
        try {
            String sql = "{call hap(?,?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, 100);
            cstmt.setInt(2, 200);
            cstmt.registerOutParameter(3, java.sql.JDBCType.INTEGER);
            
            cstmt.executeQuery();
            int h = cstmt.getInt(3);
            System.out.println(h);
            cstmt.close();
            conn.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void getPhone() {
        Connection conn = new DBConn().getConn();
        try {
            String sql = "{call getPhone(?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            cstmt.setInt(1, 1002);
            cstmt.registerOutParameter(2, java.sql.JDBCType.VARCHAR);
            
            cstmt.executeQuery();
            String p = cstmt.getString(2);
            System.out.println(p);
            cstmt.close();
            conn.close();
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new ProcedureCall().getPhone();
    }
    
}
