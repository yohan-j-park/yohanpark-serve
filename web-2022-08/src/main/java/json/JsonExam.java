package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonExam {
	public void stringToJSON() throws Exception {
		System.out.println("1번문제");
		String score = "[44,33,55,65,78]";
		int sum = 0;
		int avg = 0;
		JSONParser jParser = new JSONParser();
		Object o = jParser.parse(score);
		JSONArray jArray = (JSONArray)o;  // object를 JSONArray하면 배열이 되는 것이 아니라 배열과 유사한 List구조가 됨
		for(int i=0; i<jArray.size(); i++) {
			Long s = (Long)jArray.get(i); // List구조에서는 jArray[i]이렇게 접근하는 것이 아니라 jArray.get(i) 이렇게 접근해야함
			sum += s;
			avg = sum/jArray.size(); // size(): 실제 데이터의 갯수
		}
		System.out.println("평균: " + avg);
	
	//---------------------------------------------
	 System.out.println("-".repeat(20));
	 System.out.println("2번문제");
	 
	 String score1 = "{'id':'hong', 'name':'길동', 'phone':'010-2222'}"; 
	 score1 = score1.replace("'" , "\"");
	 JSONObject jObject = (JSONObject)jParser.parse(score1);
	 System.out.println("id: "  + jObject.get("id"));
	 System.out.println("name: "  + jObject.get("name"));
	 System.out.println("phone: "  + jObject.get("phone"));
	
	
	//---------------------------------------------
	 System.out.println("-".repeat(20));
	 System.out.println("3번문제");
	 String member = "[{ '담임' : '홍', '학생':['김', '이', '박']}," 
				+ "{ '담임' : '김', '학생':['남','최']},"
				+ "{ '담임' : '남', '학생':['김','가','나','마','사','이']}]";
	 member = member.replace("'", "\"");
	 jArray = (JSONArray)jParser.parse(member); // [ {}, {} ] 배열안에 맵구조이기 때문에 Array로 파싱
	 
	 for(int i=0; i<jArray.size(); i++) {
		jObject = (JSONObject)jArray.get(i);
		
		Object value1 = jObject.get("담임");
		Object value2 = jObject.get("학생");
		
		JSONArray jArray2 = (JSONArray)value2;
		System.out.println("담임: " + value1 + " / " + "학생 수: " + jArray2.size() + "명");

	 }
	 //---------------------------------------------
     System.out.println("-".repeat(20));
     System.out.println("4번문제");
	 String score2 = "[{'a반' : [3,4,5,6,7]},"
	                + "{'b반' : [6,5,6,7,8]},"
                    + "{'c반' : [1,3,4,5,4,3,2,3,4]}]"; 
	 
	 score2 = score2.replace("'", "\"");	     
	 
	 jArray = (JSONArray)jParser.parse(score2);
	 for(int i=0; i<jArray.size(); i++) {
	    jObject = (JSONObject)jArray.get(i);
	    System.out.println(jObject);
	    Iterator<String> iter = jObject.keySet().iterator();
	    while(iter.hasNext()) {
	        long sum1 = 0;
	        String key = (String)iter.next();
	        System.out.print(key+ " 평균: ");
	        JSONArray values = (JSONArray)jObject.get(key);
	        
	        
	        for(int j=0; j<values.size(); j++) {
	            sum1 += (long)values.get(i);
	        }
	        double ave = sum1/values.size();
	        System.out.println(ave + "점");
	    }
	    
	        
	 }
	 
	 
}
	public static void main(String[] args){
		JsonExam je = new JsonExam();
		
		try {
			je.stringToJSON();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
