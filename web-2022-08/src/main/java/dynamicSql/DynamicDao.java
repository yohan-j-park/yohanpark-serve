package dynamicSql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MyFactoryclassicmodels;

public class DynamicDao {
    SqlSession sqlSession;
    public DynamicDao() {
        sqlSession = MyFactoryclassicmodels.getFactory().openSession();
    }
    
    public void ifTest(){
        List<DynamicVo> list = null;
        list = sqlSession.selectList("dynamic.if_test","");
        for(DynamicVo vo : list) {
            System.out.print(vo.getEmployeeNumber() + " ") ;
            System.out.print(vo.getLastName()+ " ");
            System.out.print(vo.getFirstName()+ "\n" );
        }
    }
    
    public void chooseTest(){
        List<DynamicVo> list = null;
        list = sqlSession.selectList("dynamic.choose_test",2);
        for(DynamicVo vo : list) {
            System.out.print(vo.getEmployeeNumber() + " ") ;
            System.out.print(vo.getLastName()+ " ");
            System.out.print(vo.getFirstName()+ " " );
            System.out.print(vo.getEmail()+ "\n" );
        }
    }
    
    public void forEachTest() {
        int[] code = {1,3};
        List<DynamicVo> list = null;
        list = sqlSession.selectList("dynamic.forEach_test",code);
        for(DynamicVo vo : list) {
            System.out.printf("%s / %s / %s / %s / %s \n",
                               vo.getEmployeeNumber(), vo.getFirstName(),
                               vo.getLastName(), vo.getEmail(), vo.getOfficeCode());
        }
    }
    
    public static void main(String[] args) {
        DynamicDao dao = new DynamicDao();
//        dao.ifTest();
//        dao.chooseTest();
        dao.forEachTest();
    }
}
