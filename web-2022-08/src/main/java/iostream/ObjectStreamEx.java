package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamEx {
    
    List<Data> list = new ArrayList<Data>();
    String fileName = "object.obj";
    
    
    public void write() throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);   // file의 outputStream이나 file의 이름을 매개변수로 함.
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        Data d1 = new Data("aaaa","hong","서울","010-1111-2222",90);
        Data d2 = new Data("bbbb","choi","경기","010-3333-4444",80);
        Data d3 = new Data("cccc","park","인천","010-5555-6666",70);
        Data d4 = new Data("dddd","kang","부산","010-7777-8888",60);
        list.addAll(Arrays.asList(d1,d2,d3,d4));
     
        
        oos.writeObject(list);
        oos.close();        //열린 순서 반대로 close
        fos.close();        //열린 순서 반대로 close
    }
    public void read() throws Exception {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        List<Data> readData = (List<Data>)ois.readObject();
        for(Data d : readData) {
            System.out.println(d);
            ois.close();        //열린 순서 반대로 close
            fis.close();        //열린 순서 반대로 close
        }
    }
    
    public static void main(String[] args) {
        
        ObjectStreamEx ex = new ObjectStreamEx();
        try {
            ex.write();
            ex.read();
        } catch (Exception e) {
 
            e.printStackTrace();
        }
        
    }
}
