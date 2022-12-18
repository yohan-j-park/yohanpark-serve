package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	
	String driver = "com.mysql.cj.jdbc.Driver";	//드라이버명 상수
	
	String db = "classicmodels";
	String path = "jdbc:mysql://localhost:3306/";	//해당 데이터베이스 서버 오라클은 8080
	String unicode = "?useUnicode=true&characterEncoding=utf8";	//3306으로 정해져있다.
	
	String user = "hong";
	String pwd = "1111";
	Connection conn;
	
	//getConn만
	public Connection getConn() {	//가장 중요한 연결고리
		try {
			conn = DriverManager.getConnection(path+db+unicode, user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	//여기 커넥션을 만드는 절차가 가장 중요하다.
		return conn;
	}

	public DBConn(String db) {
		this();
		this.db = db;
	}
	
	public DBConn() {
		try {
			Class.forName(driver);			
			//System.out.println("connection ok~");
		} catch (Exception e) {	//통일을 시키지 않으면 catch 문을 한 번 더 써야 하는 수가 있다.
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBConn dbcon = new DBConn();
	}
}
