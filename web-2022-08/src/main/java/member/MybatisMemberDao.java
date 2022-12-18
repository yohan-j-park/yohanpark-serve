package member;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyFactory;
import servlet.MybatisMemberFileUploadServlet;

public class MybatisMemberDao {
    SqlSession sqlSession;
    MybatisPageVo pVo;
    public MybatisMemberDao() {
        sqlSession = MyFactory.getFactory().openSession();      // mybatis에서 DBConn을 만드는 작업과 같은 역할
    }
    
    public String insert(MemberVo vo) {
        String msg = "입력 완료";
        int cnt=0;
        try {
            cnt = sqlSession.insert("member.insert", vo);   
            if(cnt>0) {
                msg="저장 성공";
                sqlSession.commit();
            }else {
                msg="저장 중 오류 발생";
                sqlSession.rollback();
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return msg;
    }
    
    public List<MemberVo> select(MybatisPageVo pVo) {
        List<MemberVo> list = null;
        sqlSession = MyFactory.getFactory().openSession();      // mybatis에서 DBConn을 만드는 작업과 같은 역할

        // 1) 검색어에 해당하는 전체 게시물에 해당하는 개수(totSize)
        int totSize = sqlSession.selectOne("member.totSize",pVo.getFindStr());   
        // 2) page계산
        pVo.setTotSize(totSize);
        pVo.compute();
        this.pVo = pVo;
        // 3) select
        list = sqlSession.selectList("member.select",pVo);
        sqlSession.close();      
        
        return list;        
        
    }
    
    public MemberVo view(String id) {
        MemberVo bVo = null;        
        bVo = sqlSession.selectOne("member.view",id);
        
        sqlSession.close();
        return bVo;
    }
    
    public String update(MemberVo vo) {
        String msg="";
        int cnt = sqlSession.update("member.update", vo);
            if(cnt>0) {
                sqlSession.commit();
                msg="수정됨";
            }else{
               sqlSession.rollback();
               msg="수정 중 오류 발생";
            }
        return msg;       
    }
    
    public String delete(String id, String delFile) {
        String msg = "삭제됨";
        int cnt = sqlSession.delete("member.delete", id);
        if(cnt>0) {
            sqlSession.commit();
            File file = new File(MybatisMemberFileUploadServlet.path + delFile);
            if(file.exists()) file.delete();
            msg="정상적으로 삭제됨";
        }else {
            sqlSession.rollback();
            msg="삭제중 오류 발생";
        }    
        return msg;      
    }

    public MybatisPageVo getpVo() {
        return pVo;
    }
    
}
