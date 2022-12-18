package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEx {
    public void test1() {   //crud
        Map<String, String> hm = new HashMap<String, String>();     //객체의 다형성, 제너릭에 특정값을 지정하지 않으면 object형임
        
        //입력
        hm.put("a1", "aaaa");
        hm.put("a2", "bbbb");
        hm.put("a3", "cccc");
        System.out.println(hm);
        
        //수정
        hm.put("a2", "홍길동");
        System.out.println(hm);
        
        //삭제
        hm.remove("a2");
        System.out.println(hm);
        
        //조회(key값을 알고 있는 경우)
        System.out.println(hm.get("a1"));
        System.out.println(hm.get("a3"));
        
        //조회(key값을모르는 경우)
        Set<String> set = hm.keySet();      // 순서대로 나오지 않음
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
            String key = iter.next();
            System.out.println(hm.get(key)); // a1 a3순서대로 나왔지만 사실 랜덤
         
        //조회(key값은 필요없고 value값만 필요할 때)
        Collection<String> values =  hm.values();
        iter = values.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
//          set구조와 map구조는 iterator를 만드는 것이 관건이다
            }
        }
        
        //Map.Entery
        Set<Map.Entry<String, String>> set2 = hm.entrySet();
        Iterator<Map.Entry<String, String>> iter2 = set2.iterator();
        while(iter2.hasNext()) {
            Map.Entry entry = iter2.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        
        //value값이 Data클래스(Object)인 경우
        Map<String, Data> hm3 = new HashMap<String, Data>();
        hm3.put("a001", new Data("a001", "hong", 18));
        hm3.put("b001", new Data("b001", "kim", 20));
        hm3.put("c001", new Data("c001", "park", 30));
        //key값을 기준으로
        Set<String> set3 = hm3.keySet();
        Iterator<String> iter3 = set3.iterator();       // set구조는 index값이 없기 때문에 iterator사용해야함
        while(iter3.hasNext()) {
            String key = iter3.next();
            Data d = hm3.get(key);
            System.out.println(d);
        }
        
    }
    
    public static void main(String[] args) {
        new MapEx().test1();
    }
}
