package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ScoreDto {
    Connection conn;
    
    public int insert(ScoreVo vo) {
        int cnt = 0;
        conn = new DBConn("mydb").getConn();
        try {
            conn.setAutoCommit(false);
            String sql = "insert into score(serial, id, mdate, subject, score) "
                        +"values(?,?,now(),?,?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vo.getSerial());
            ps.setString(2, vo.getId());
            ps.setString(3, vo.getSubject());
            ps.setInt(4, vo.getScore());
            
            cnt = ps.executeUpdate();
            if(cnt>0) conn.commit();
            else conn.rollback();
            
            ps.close();
            conn.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return cnt;
    }
    public int update(ScoreVo vo) {
        int cnt = 0;
        try {
            conn = new DBConn("mydb").getConn();
            conn.setAutoCommit(false);
            String sql = "update score set id=?, subject=?, score=? where serial=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getSubject());
            ps.setInt(3, vo.getScore());
            ps.setInt(4, vo.getSerial());
            
            cnt = ps.executeUpdate();
            if(cnt>0) conn.commit();
            else conn.rollback();
            
            ps.close();
            conn.close();
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }
    
    public int delete(int serial) {
        int cnt = 0;
        try {
            conn = new DBConn("mydb").getConn();
            conn.setAutoCommit(false);
            String sql = "delete from score where serial=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, serial);
            cnt = ps.executeUpdate();
            if(cnt>0) conn.commit();
            else conn.rollback();
            
            ps.close();
            conn.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }
        
        public Vector<Vector> select(String findStr){
            Vector<Vector> list = new Vector<Vector>();
            try {
                conn = new DBConn("mydb").getConn();
                String sql = "select * from score "
                        +    "where id like ? "
                        +    "or subject like ? ";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+findStr+"%");
                ps.setString(2, "%"+findStr+"%");
                
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    Vector v = new Vector();
                    v.add(rs.getInt("serial"));
                    v.add(rs.getString("id"));
                    v.add(rs.getString("mdate"));
                    v.add(rs.getString("subject"));
                    v.add(rs.getInt("score"));
                    list.add(v);
                }
                        
                
            }catch(Exception e) {
                e.printStackTrace();
            }
            return list;
            
        }
        public ScoreVo SelectOne(Integer serial) {
            ScoreVo vo = new ScoreVo();
            try {
                String sql = "select * from score where serial=?";
                conn = new DBConn("mydb").getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, serial);
                
                ResultSet rs = ps.executeQuery();
                if(rs.next()) {
                    vo.setSerial(rs.getInt("serial"));
                    vo.setId(rs.getString("id"));
                    vo.setMdate(rs.getString("mdate"));
                    vo.setSubject(rs.getString("subject"));
                    vo.setScore(rs.getInt("score"));
                    
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
            return vo;
        }
    
}
