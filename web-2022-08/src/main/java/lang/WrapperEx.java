package lang;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WrapperEx {
    public void test() {
        String x = "123";
        String y = "456";
     System.out.println("x+y= " + (x+y));   
     
     int n1 = Integer.parseInt(x);
     int n2 = Integer.parseInt(y);
     
     System.out.println("n1+n2= " + (n1+n2));
    }
    
    public void test2() {
        String x = "123.456";
        String y = "3.14";
        System.out.println(x+y);
        double d1 = Double.parseDouble(x);
        double d2 = Double.parseDouble(y);
        
        System.out.println(d1+d2);
    }
    public void test3(){
        String score="[70,80,90,60,60]";
        int sum = 0;
        double avg = 0;
        // JSON 유형으로 전달된 성적의 합계와 평균을 구하시오
        
        // 1) JSONArray로 파싱
        JSONParser jparser = new JSONParser();
        try {
           JSONArray jArray = (JSONArray)jparser.parse(score); // List 구조
           
        // 2) List 구조의 값을 사용하여 합계와 평균을 계산.
           for(int i=0; i<jArray.size(); i++) {
               System.out.println(jArray.get(i));
               Object o = jArray.get(i);
               Long su = (Long)o;
               sum += su;
        }
           avg = (double)sum/jArray.size();
           System.out.println("sum : " + sum);
           System.out.println("avg : " + avg);
           
        } catch (ParseException e) {
            e.printStackTrace();
        }   
        System.out.println("합계: " + sum);
        System.out.println("평균: " + avg);
      
        
    }
    
    public void Test4() {   //합계와 평균
        String score="['10','20','30','40','50']";
        score = score.replace("'","\"");
        JSONParser jparser = new JSONParser();
        try {
            JSONArray jArray = (JSONArray)jparser.parse(score);
            long sum = 0l;
            
            for(int i=0; i<jArray.size(); i++) {
              sum += Long.parseLong((String)jArray.get(i));
            }
            double avg = sum/jArray.size();
            
            System.out.printf("sum : %d, avg : %.1f", sum, avg);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) { 
        WrapperEx ex = new WrapperEx(); 
        ex.test(); 
        ex.test2();
        ex.test3();
        ex.Test4();

    }
}
