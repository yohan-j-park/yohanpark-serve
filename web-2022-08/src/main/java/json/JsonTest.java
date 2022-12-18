package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonTest {
	public void stringToJSON() throws Exception {
		System.out.println("1. 정수형 배열을 JSONArray");
		String jsonInt = "[1,2,3,4,5]";
		JSONParser jParser = new JSONParser();
		Object o = jParser.parse(jsonInt);
		JSONArray jArray = (JSONArray)o;
		
		System.out.println(jArray.toJSONString());
		
		for(int i=0; i<jArray.size(); i++) {
			Long s =(Long)jArray.get(i);
			System.out.printf("%d : %d\n" , i, s);
		}
	
		//---------------------------------------------
	 System.out.println("-".repeat(20));
	 System.out.println("2. 문자열 배열을 JSONArray");
	 
	 String jsonString = "['a', 'b', '1', 'c']"; 
	 jsonString = jsonString.replace("'" , "\"");
	 jArray = (JSONArray)jParser.parse(jsonString);
	 System.out.println(jArray.toJSONString());
	 for(int i=0; i<jArray.size(); i++) {
		 System.out.printf("%d : %s\n", i, jArray.get(i));
	 }
	
	 //---------------------------------------------
	 System.out.println("-".repeat(20));
	 System.out.println("3. map 구조물 JSONObject");
	 String jsonMap = "{'name' : 'hong' , 'age' : '20'}";
	 jsonMap = jsonMap.replace("'", "\"");
	 JSONObject jObject = (JSONObject)jParser.parse(jsonMap);
	 System.out.println("name : "  + jObject.get("name"));
	 System.out.println("age  : "  + jObject.get("age"));
	 
	 //---------------------------------------------
	 System.out.println("-".repeat(20));
	 System.out.println("4. ");
	 String jsonListMap = "[{'name':'hong' , 'addr':'seoul'},{'name':'kim' , 'addr':'busan'}]";
	 jsonListMap = jsonListMap.replace("'", "\"");
	 jArray = (JSONArray)jParser.parse(jsonListMap);
	 for(Object o2 : jArray) {
		 JSONObject job = (JSONObject)o2;
		 System.out.println("name : " + job.get("name"));
		 System.out.println("addr : " + job.get("addr"));
	 }
	 
	 //---------------------------------------------
	 System.out.println("-".repeat(20));
	 jsonString = "{'names' : ['a','b','c','d']}";
	 jsonString = jsonString.replace("'", "\"");
	 jObject = (JSONObject)jParser.parse(jsonString);
	 Object value = jObject.get("names");
	 jArray = (JSONArray)value;
	 for(Object ob : jArray) {
		 System.out.println(ob);
	 }
	 
	 //---------------------------------------------
	 System.out.println("-".repeat(20));
	 jsonString = "[{'names' : ['a','b','c']} , {'ages' :[5,6,7]}]";
	 jsonString = jsonString.replace("'","\"");
	 jArray = (JSONArray)jParser.parse(jsonString);
	 System.out.println(jArray.toJSONString());
	 for(int i=0; i<jArray.size(); i++){
		 jObject = (JSONObject)jArray.get(i);
		 Iterator<String> iter = jObject.keySet().iterator();// 반환형 set구조
		 while(iter.hasNext()) {
			 String key = (String)iter.next(); // 배열마다 가지고 있는 key의 개수가 다를 수도 있기 때문
			 JSONArray values = (JSONArray)jObject.get(key);
			
			 System.out.println(values.toJSONString());
		 }
	 } // 첨자가 필요 없을 때
	 for(Object ob : jArray) { 
		 
	 } // 첨자가 필요할 때
}
	public static void main(String[] args){
		JsonTest jt = new JsonTest();
		
		try {
			jt.stringToJSON();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
