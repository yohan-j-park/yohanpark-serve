package member;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jdbc.DBConn;
import servlet.MemberFileUploadServlet;

public class MemberDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    public MemberDao() {
        conn = new DBConn("mydb").getConn();
    }
    
    public String insert(MemberVo vo) {
        String msg = "입력 완료";
        String sql = "insert into member(id, name, gender, phone, sysFile, oriFile) "
                +    " values(?,?,?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getName());
            ps.setString(3, vo.getGender());
            ps.setString(4, vo.getPhone());
            ps.setString(5, vo.getSysFile());
            ps.setString(6, vo.getOriFile());
            
            int cnt = ps.executeUpdate();
            
            if(cnt>0) {
                conn.commit();
                msg="저장 성공";
            }else {
                conn.rollback();
                msg="저장 중 오류 발생";
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println(msg);
        return msg;
    }
    
    public JSONArray select(String findStr) {
        JSONArray array = new JSONArray(); 
        String sql = "select * from member where id like ? or phone like ? or name like ? ";
        try {
            
            ps = conn.prepareCall(sql);
            ps.setString(1, "%" + findStr + "%");
            ps.setString(2, "%" + findStr + "%");
            ps.setString(3, "%" + findStr + "%");
            rs = ps.executeQuery();
            
            while(rs.next()) {
                JSONObject obj = new JSONObject();
                obj.put("id", rs.getString("id"));
                obj.put("name", rs.getString("name"));
                obj.put("phone", rs.getString("phone"));
                obj.put("gender", rs.getString("gender"));
                obj.put("sysFile", rs.getString("sysFile"));
                obj.put("oriFile", rs.getString("oriFile"));
                array.add(obj);          
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return array;        
        
    }
    
    public JSONObject view(String id) {
        JSONObject obj = new JSONObject();
        String sql = "select * from member where id=?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                obj.put("id", rs.getString("id"));
                obj.put("name", rs.getString("name"));
                obj.put("phone", rs.getString("phone"));
                obj.put("gender", rs.getString("gender"));
                obj.put("sysFile", rs.getString("sysFile"));
                obj.put("oriFile", rs.getString("oriFile"));
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
    
    public String update(MemberVo vo) {
        String msg="하이...";
        String sql="";
        
        try {
            // 파일 삭제
            if(!vo.getSysFile().equals("")) {
                File delFile = new File(MemberFileUploadServlet.path + vo.getDelFile());
                if(delFile.exists()) delFile.delete();
            }
            // table update
            conn.setAutoCommit(false);
            if(!vo.getSysFile().equals("")) {   //첨부파일이 있는 경우
                sql="update member set name=?, phone=?, gender=?, sysFile=?, oriFile=? where id=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, vo.getName());
                ps.setString(2, vo.getPhone());
                ps.setString(3, vo.getGender());
                ps.setString(4, vo.getSysFile());
                ps.setString(5, vo.getOriFile());
                ps.setString(6, vo.getId());
            }else {     // 첨부파일이 없는 경우
                sql="update member set name=?, phone=?, gender=? where id=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, vo.getName());
                ps.setString(2, vo.getPhone());
                ps.setString(3, vo.getGender());
                ps.setString(4, vo.getId());
            }
            int cnt = ps.executeUpdate();
            if(cnt>0) {
                msg="수정완료";
                conn.commit();
                
            }else{
                msg="수정 중 오류 발생";
                conn.rollback();
            }
            
        }catch(Exception e) {
            e.printStackTrace();
            msg=e.getMessage();
        }
        return msg;
        
    }
    public String delete(String id, String delFile) {
        String msg = "삭제됨";
        String sql = "delete from member where id=?";
        try {
        conn.setAutoCommit(false);
        ps = conn.prepareStatement(sql);
        ps.setString(1, id);
        int cnt = ps.executeUpdate();
        if(cnt>0) {
            conn.commit();
            File file = new File(MemberFileUploadServlet.path + delFile);
            if(file.exists())  file.delete();
        }else {
            conn.rollback();
            msg = "삭제중 오류 발생";
            }
        }catch(Exception e) {
            e.printStackTrace();
        }         
        return msg;      
    }
}
