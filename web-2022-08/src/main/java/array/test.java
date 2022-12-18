package array;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class test {
    
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        
        
        map.put("id", "a001");
        map.put("name", "kim");
        
        JSONObject obj = new JSONObject();
        
        obj.put("id", "b001");
        obj.put("name", "park");
        
        
        System.out.println(map.toString());
        System.out.println(obj.toJSONString());
    }
}
