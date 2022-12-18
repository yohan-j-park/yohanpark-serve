package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {   //데이터베이스커넥션
       String db = "classicmodels";
       String driver = "com.mysql.cj.jdbc.Driver";     // JDBC Driver Class
       String path = "jdbc:mysql://localhost:3306/";       // 연결문자열, localhost
       String unicode ="?useUnicode=true&characterEncoding=utf8";  
       String user = "hong";       // 데이터베이스 ID
       String pwd = "1111";        // 데이터베이스 PW
    
    Connection conn;        //Connection: 데이터베이스와 연결하는 객체
    
    
    
    public DBConn() {
        try {
            Class.forName(driver);      //JDBC 드라이버 로딩
            
//            System.out.println("Connection Ok");
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
    public DBConn(String db) {
        this();
        this.db = db;
    }
    
    public static void main(String[] args) {        // 잘 작동하는지 단독으로 실행해 보기 위해 main method를 만들었음. 없어도 무관
        DBConn dbconn = new DBConn();       
    }
    public Connection getConn() {
        try {
            conn = DriverManager.getConnection(path+db+unicode, user, pwd);        //Connection 생성 및 데이터베이스 연결
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return conn;
    }
   

    

}
