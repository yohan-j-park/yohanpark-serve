package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class Employee {         //CRUD 연습
    Connection conn;
    public Employee() {
        this.conn = new DBConn().getConn();         //
    }
    
    public void insert() throws Exception {
        conn.setAutoCommit(false);      // 꼭 해야함..
        String sql = "insert into test(id, name) values(?,?)";      // values('e001', '나씨') mysql에서 문자열은 ' ' 안에 기술
        PreparedStatement ps = conn.prepareStatement(sql);     
        ps.setString(1, "e001");
        ps.setString(2, "나씨");
        
        int cnt = ps.executeUpdate();       // executeUpdate: 실행명령어
        if(cnt>0) conn.commit();        // 적용된 행 수가 0 이상이면(1베이스) commit
        else conn.rollback();           // 적용된 것이 없으면 rollback
        
        ps.close();         //자원을 반환하기 위하여 종료를 꼭 해야함
        conn.close();       //자원을 반환하기 위하여 종료를 꼭 해야함
    }
    public void select() throws Exception {
        conn = new DBConn().getConn();
        String sql = "select * from test";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();         // select문장은 executeQuery()사용 ResultSet 객체로 반환 => 명시적 커서
        while(rs.next()) {    
            // rs.next()해석 
//             1) 현재 데이터를 반환하고 다음 위치로 이동한다.
//             2) 현재 위치를 bof(bot) begin of file(tape)로 보고 다음을 반환한다, 
//                eof(eot)end of file(tape)가 나올 때 까지 [~f:file, ~t:tape] BOT A B C D EOT 
            String id = rs.getString("id");       //id에 있는 필드명을 문자로 가지고오다
            String name = rs.getString("name");
            System.out.printf("id:%s(%s)\n", id, name);
        }
            
            ps.close(); 
            conn.close();   // close 안하면 서버다운됨
    }
    public void update() throws Exception{
        conn = new DBConn().getConn();
        conn.setAutoCommit(false);
        String sql = "update test set name=? where id=?";   // test라는 테이블에서 id가 ?인것을 찾아 이름을 ?로 바꾸겠다.
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "가씨");
        ps.setString(2, "e001");
        int cnt = ps.executeUpdate();

        //검증코드
        if(cnt>0) conn.commit();
        else conn.rollback();   
    }
    public void delete() throws Exception{
        conn = new DBConn().getConn();
        conn.setAutoCommit(false);
        String sql = "delete from test where id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "b001");
        int cnt = ps.executeUpdate();
        
        if(cnt>0) {
            System.out.println("삭제되었습니다.");
            conn.commit();
        }
        else {
            System.out.println("삭제 할 자료가 없습니다.");
            conn.rollback();
        }
        ps.close();
        conn.close();
        select();
        
        
    }
    public void metaTest() throws Exception{
        conn = new DBConn().getConn();
        String sql = "select * from offices";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData meta = rs.getMetaData();
        
        // select절에서 선택한 컬럼명
        for(int i=1; i<=meta.getColumnCount(); i++) {
            System.out.printf("%-20s", meta.getColumnName(i));
        }
        System.out.println();
        System.out.println("-".repeat(180));
        while(rs.next()) {
            for(int i=1; i<=meta.getColumnCount(); i++) {
                String cn = meta.getColumnName(i);
                System.out.printf("%-20s", rs.getString(cn));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Employee e = new Employee();
        try {
//            e.insert();
//            e.select();
//            e.update();
//            e.delete();
            e.metaTest();
        } catch (Exception e1) {

            e1.printStackTrace();
        }
    }

}
