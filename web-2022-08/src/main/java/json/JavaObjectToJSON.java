package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class JavaObjectToJSON {
    
    public JavaObjectToJSON() {
        //-------------------------
        JSONObject obj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        obj.put("name", "홍길동"); 
        obj.put("score", 90); // 90은 Integer(90)으로 autoboxing된다. 
        obj.put("addre", "봉천동");
        
     // object type : 자바가 사용할 수 있는 모든 키값과 value값을 가지고 맵구조를 만들 수 있다.
     // 숫자를 key값으로 넣으려면 Integer()를 사용하여야 한다.
        System.out.println(obj.toJSONString());
        System.out.println("name  : " + obj.get("name"));
        System.out.println("score : " + obj.get("score"));
        System.out.println("addre : " + obj.get("addre"));
        System.out.println("-".repeat(20));

        // key값을 알 수 없는 경우 및 key값이 바뀌는 경우----------------------------
       Set<String> set = obj.keySet(); //중복되지 않고 순서가 정해져 있지 않는 구조
       Iterator<String> iter = set.iterator();
       
       do { 
           String key = iter.next();
           System.out.println(key + " : " + obj.get(key));      
       }
       while(iter.hasNext());       
    
    //---------------------------------------
    Test t1 = new Test("abc", 123);
    t1.setIrum("홍길동");
    t1.setScore(60);
    
    Test t2 = new Test("abc", 123);
    t2.setIrum("지매");
    t2.setScore(90);
    
    obj = new JSONObject();
    obj.put("o1",t1);
    obj.put("o2",t2);
    
    System.out.println(obj.toJSONString());
    // obj에 저장된 Test객체를 가져와 출력
    Test t3 = (Test)obj.get("o1");
    System.out.println("t3.irum : " + t3.getIrum());
    System.out.println("t3.score : " + t3.getScore());
    
    // 키가 o2인 값을 Test t4에 저장하여 출력
    Test t4 = (Test)obj.get("o2");
    System.out.println("t4.irum : " + t4.getIrum());
    System.out.println("t4.score : " + t4.getScore());
    
    // JSON array object
    System.out.println("-".repeat(20));
    System.out.println("4. json array object");
    JSONArray array = new JSONArray();
//  System.out.println(array); // []
    obj = new JSONObject();
    obj.put("name", "Park");
    obj.put("phone", "010");
    
//  System.out.println(obj); // {"phone":"010","name":"Park"}
    array.add(obj);
    array.add(obj);
    array.add(obj);
    
//  System.out.println(obj.get("name")); // Park 
    
    for(Object o : array) {
        System.out.println(o); 
    // {"phone":"010","name":"Park"}\n X3
    }
    for(Object o : array) {
        obj = (JSONObject) o;
        System.out.println(obj.toJSONString());
    // {"phone":"010","name":"Park"}\n X3
    } 
    System.out.println(array);
    // [{"phone":"010","name":"Park"},{"phone":"010","name":"Park"},{"phone":"010","name":"Park"}]

    //------------------------------------------------
    System.out.println("-".repeat(20));
    System.out.println("5. Map to JSONObject");
    
    Map<String,Object> map = new HashMap<String, Object>();
//  System.out.println(map); // { }
    map.put("name", "choi");
    map.put("age", 20);
//  System.out.println(map); // {name=choi, age=20}
    
    obj = new JSONObject(map);
//  System.out.println(map); // {name=choi, age=20}
    
    System.out.println("name : " + obj.get("name"));
    System.out.println("age : " + obj.get("age"));
    //-------------------------------------    
    System.out.println("-".repeat(20));
    List<String>list = new ArrayList<String>();
    list.add("A");
    list.add("B");
    list.add("C");
//  System.out.println(list);  // [A,B,C]
    jsonArray.clear();
    jsonArray.addAll(list);
    
    for(Object s : jsonArray) {
        System.out.println(s); // A \n B \n C
    }
    //-------------------------------------
    System.out.println("-".repeat(20));
    System.out.println("6. JavaObject to JSONArray");
    
    List<Test> listTest = new ArrayList<Test>();
//  System.out.println(listTest); // []
   
    
    listTest.add(new Test("kim", 20));
    listTest.add(new Test("hong", 30));

//  System.out.println(jsonArray); // []
    jsonArray.clear();
    jsonArray.addAll(listTest);
    System.out.println(jsonArray);
    
    for (Object o : jsonArray) {
        Test t = (Test)o;
        System.out.println(t.getIrum() + "," + t.getScore());
        System.out.println(JSONValue.toJSONString(t));
    }
    
    
  }
 
    
    public static void main(String[] args) {
        new JavaObjectToJSON(); // 
    }
}

