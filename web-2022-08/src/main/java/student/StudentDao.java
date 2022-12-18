package student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crypto.AES;
import jdbc.DBConn;

public class StudentDao {
    Connection conn;
    
    public StudentDao() {
        try {
            conn = new DBConn("mydb").getConn();
        }catch(Exception e) {
            e.printStackTrace();
        }
       
    }
    
    
    public boolean insert(StudentVo vo)  {
        boolean b = false;
        
        // 사용자암호를 암호화하기
        String temPwd = vo.getPwd();
        AES aes = new AES();
        String encPwd = aes.encrypt(temPwd);
        vo.setPwd(encPwd);
        
        String sql = "insert into student(id,name,phone,pwd,address,address2,gender,email,zipcode)"
                + " values(?,?,?,?,?,?,?,?,?)";
        
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getName());
            ps.setString(3, vo.getPhone());
            ps.setString(4, vo.getPwd());
            ps.setString(5, vo.getAddress());
            ps.setString(6, vo.getAddress2());
            ps.setString(7, vo.getGender());
            ps.setString(8, vo.getEmail());
            ps.setString(9, vo.getZipcode());
            int cnt = ps.executeUpdate();
            //INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환합니다.
            if(cnt>0) {
                conn.commit();
                b=true;
            }
            ps.close();
            conn.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public List<StudentVo> select(Page pageVo){
        List<StudentVo> list = new ArrayList<StudentVo>();
        String sql ="";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        //검색된 전체 건수
        try {
         
        sql = "select count(id) as totSize from student "
            + " where id like ? "
            + " or name like ? "
            + " or phone like ? "
            + " or address like ? "
            + " or address2 like ? "
            + " or email like ? ";
        
        ps = conn.prepareStatement(sql);
        //Statement는 객체를 캐시에 담아 재사용, 반복적으로 쿼리를 수행하려면
        //PreparedStatement가 유리함. 또한 그냥 Statement는 보안에 취약
        //Statement는 쿼리에 변수값을 직접 대입, prepared는 ?를 넣는다.
        ps.setString(1, "%"+pageVo.getFindStr()+"%");
        ps.setString(2, "%"+pageVo.getFindStr()+"%");
        ps.setString(3, "%"+pageVo.getFindStr()+"%");
        ps.setString(4, "%"+pageVo.getFindStr()+"%");
        ps.setString(5, "%"+pageVo.getFindStr()+"%");
        ps.setString(6, "%"+pageVo.getFindStr()+"%");

        
        rs = ps.executeQuery();
        rs.next();
        int totSize = rs.getInt("totSize");
        pageVo.setTotSize(totSize);
        pageVo.compute();
       
            
        sql = "select * from student "
              +    "where id like ? "
              +    "or name like ? "
              +    "or phone like ? "
              +    "or address like ? "
              +    "or address2 like ? "
              +    "or email like ? "
              +    "order by name asc "
              +    "limit ?,? ";
                    
            
            ps = conn.prepareStatement(sql);
            //Statement는 객체를 캐시에 담아 재사용, 반복적으로 쿼리를 수행하려면
            //PreparedStatement가 유리함. 또한 그냥 Statement는 보안에 취약
            //Statement는 쿼리에 변수값을 직접 대입, prepared는 ?를 넣는다.
            ps.setString(1, "%"+pageVo.getFindStr()+"%");
            ps.setString(2, "%"+pageVo.getFindStr()+"%");
            ps.setString(3, "%"+pageVo.getFindStr()+"%");
            ps.setString(4, "%"+pageVo.getFindStr()+"%");
            ps.setString(5, "%"+pageVo.getFindStr()+"%");
            ps.setString(6, "%"+pageVo.getFindStr()+"%");
            ps.setInt(7, pageVo.getStartNo());
            ps.setInt(8, pageVo.getListSize());
            
            rs = ps.executeQuery();
            //ResultSet은 Statement를 통해 값을 저장할 수 있다.
            //ExcuteQuery: 수행 결과로 ResultSet 객체의 값을 반환함
            //Select구문을 수행할 때 사용되는 메소드
            
            while(rs.next()) {
                StudentVo vo = new StudentVo();
                vo.setId(rs.getString("id"));
                vo.setName(rs.getString("name"));
                vo.setPhone(rs.getString("phone"));
                vo.setZipcode(rs.getString("zipcode"));
                vo.setAddress(rs.getString("address"));
                vo.setAddress2(rs.getString("address2"));
                vo.setGender(rs.getString("gender"));
                vo.setEmail(rs.getString("email"));
                
                list.add(vo);
            }
                ps.close();
                conn.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public StudentVo view(String id) {
        StudentVo vo = new StudentVo();
        String sql = "select * from student where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                vo.setId(rs.getString("id"));
                vo.setName(rs.getString("name"));
                vo.setPhone(rs.getString("phone"));
                vo.setZipcode(rs.getString("zipcode"));
                vo.setAddress(rs.getString("address"));
                vo.setAddress2(rs.getString("address2"));
                vo.setGender(rs.getString("gender"));
                vo.setEmail(rs.getString("email"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
    
    public boolean modify(StudentVo vo) {
        
        // 사용자암호를 암호화하기
        String temPwd = vo.getPwd();
        AES aes = new AES();
        String encPwd = aes.encrypt(temPwd);
        vo.setPwd(encPwd);
        
        boolean b=false;
        String sql = " update student set name=?, gender=?, phone=?, zipcode=?,"
                +    " address=?, address2=?, email=? where id=? and pwd=?  ";
        
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getName());
            ps.setString(2, vo.getGender());
            ps.setString(3, vo.getPhone());
            ps.setString(4, vo.getZipcode());
            ps.setString(5, vo.getAddress());
            ps.setString(6, vo.getAddress2());
            ps.setString(7, vo.getEmail());
            ps.setString(8, vo.getId());
            ps.setString(9, vo.getPwd());
            
            int cnt=ps.executeUpdate();
            if(cnt>0) {
                b=true;
                conn.commit();
            }else conn.rollback();
            ps.close();
            conn.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    
    public boolean delete(StudentVo vo) {
        if(conn == null) conn = new DBConn("mydb").getConn();
        
        // 사용자암호를 암호화하기
        String temPwd = vo.getPwd();
        AES aes = new AES();
        String encPwd = aes.encrypt(temPwd);
        vo.setPwd(encPwd);
        
        
        boolean b=false;
        String sql = "delete from student where id=? and pwd=?"; 
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getPwd());
            
            int cnt = ps.executeUpdate();
            
            if(cnt>0) { 
                b=true; 
                conn.commit(); 
            }else conn.rollback();
            ps.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
    
}
