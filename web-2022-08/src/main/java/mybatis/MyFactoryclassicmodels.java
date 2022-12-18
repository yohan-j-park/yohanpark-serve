package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyFactoryclassicmodels {
    
    private static SqlSessionFactory factory;
    static {
        try {
            Reader r = Resources.getResourceAsReader("mybatis/configclassicmodels.xml");    // 경로를 적지 않으면 Web_inf안에 classic이라는 폴더를 따로 생성해서 넣어야 함.
            factory = new SqlSessionFactoryBuilder().build(r);
        }catch(Exception e) {
            e.printStackTrace();
        }   
    }
    public static SqlSessionFactory getFactory() {
     
        return factory;
    }
    
//    main method는 출력을 위해 만든 것. 없어도 됨
//    
//    public static void main(String[] args) {
//    
//       session 객체를 통해 CRUD를 실제 실행함
//    
//       SqlSession session = MyFactory.getFactory().openSession(); 
//       if(session==null) {
//           System.out.println("factory 실행 오류");
//       }else {
//           System.out.println("factory가 생성되었습니다.");
//       }
//    }
    
    
}
