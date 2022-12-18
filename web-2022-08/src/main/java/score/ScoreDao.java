package score;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyFactory;

public class ScoreDao {
    SqlSession sqlSession;
    ScorePageVo pVo;
    public ScoreDao() {
        sqlSession = MyFactory.getFactory().openSession();      // mybatis에서 DBConn을 만드는 작업과 같은 역할
    }
    
    public String insert(ScoreVo vo) {
        String msg = "입력 완료";
        int cnt=0;
        try {
            cnt = sqlSession.insert("score.insert", vo);   
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
    
    public List<ScoreVo> select(ScorePageVo pVo) {
        List<ScoreVo> list = null;
        // 1) 검색어에 해당하는 전체 게시물에 해당하는 개수(totSize)
        
        int totSize = sqlSession.selectOne("score.totSize",pVo.getFindStr());
        // 2) page계산
        pVo.setTotSize(totSize);
        pVo.compute();
        this.pVo = pVo;
        // 3) select
        list = sqlSession.selectList("score.select",pVo);
        sqlSession.close();      
        return list;        
        
    }
    
    public ScoreVo view(String id) {
        ScoreVo bVo = null;        
        bVo = sqlSession.selectOne("score.view",id);
        sqlSession.close();
        return bVo;
    }
    
    public String update(ScoreVo vo) {
        String msg="";
        int cnt = sqlSession.update("score.update", vo);
        System.out.println(cnt);
            if(cnt>0) {
                sqlSession.commit();
                msg="수정됨";
            }else{
               sqlSession.rollback();
               msg="수정 중 오류 발생";
            }
        return msg;       
    }
    
    public String delete(String id) {
        String msg = "삭제됨";
        int cnt = sqlSession.delete("score.delete", id);
        if(cnt>0) {
            sqlSession.commit();
            msg="정상적으로 삭제됨";
        }else {
            sqlSession.rollback();
            msg="삭제중 오류 발생";
        }    
        return msg;      
    }
    
    public ScorePageVo getpVo() {
        return pVo;
    }
    
}
