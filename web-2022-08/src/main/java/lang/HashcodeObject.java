package lang;

public class HashcodeObject {
        
        int id;
        public  HashcodeObject(int id) {
            this.id = id;
        } 
        @Override
        public int hashCode() {
  
            return this.id;
        } 
        
        public static void main(String[] args) {
        // HashCode()메소드를 재정의 한 이후
        HashcodeObject o3 = new HashcodeObject(100);
        HashcodeObject o4 = new HashcodeObject(100);
        
        System.out.println(o3.hashCode());
        System.out.println(o4.hashCode());
        System.out.println(o3 == o4);       //false
        System.out.println(o3.equals(o4));  //false
        

        /*
        HashcodeObject o1 = new HashcodeObject();
        HashcodeObject o2 = new HashcodeObject();
        
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        
        System.out.println(o1.equals(02));  //false
        System.out.println(o1==o2);         //false 
             */
        
    }

}
