package iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ObjectStreamEx2 {
//  
    List<Score> list = new ArrayList<Score>();
    String fileName = "object2.obj";
    
    public void write() throws Exception{
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        
        Score s1 = new Score("a001",65,35,78);
        Score s2 = new Score("b001",68,88,13);
        Score s3 = new Score("c001",76,15,35);
        Score s4 = new Score("d001",64,45,33);
        list.addAll(Arrays.asList(s1,s2,s3,s4));
        
        oos.writeObject(list);
        oos.close();
        fos.close();            
    }
    public void read() throws Exception {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
//      list = (List<Score>) ois.readObject();  
        
//      list.forEach(x->System.out.print(x));  
        
        List<Score> readData = (List<Score>)ois.readObject();
        for(Score s : readData) {
            System.out.println(s);
            ois.close();
            fis.close();
        }
    }

 
    public static void main(String[] args) {
       ObjectStreamEx2 ose2 = new ObjectStreamEx2();
       try {
           ose2.write();
           ose2.read();
       }catch(Exception e) {
           e.printStackTrace();
       }
    }
  
}
