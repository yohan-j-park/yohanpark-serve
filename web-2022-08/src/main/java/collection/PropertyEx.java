package collection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertyEx {
    
    public void store() throws IOException {
        File f = new File("my.property");
        if(!f.exists() ) {
            f.createNewFile();
        }
        Properties prop = new Properties();
        prop.setProperty("id"   , "a001");
        prop.setProperty("irum" , "홍길동");
        prop.setProperty("phone", "02-1234-5678");
        
        String path = URLDecoder.decode(f.getPath(), "utf-8");
        System.out.println("path : " + path);
        FileWriter fw = new FileWriter(path);
        prop.store(fw, "");
        fw.close();
        
    }
    
    public void load() throws IOException{
        String path = "my.property";
        path = URLDecoder.decode(path, "utf-8");
        FileReader fr = new FileReader(path);
        Properties prop = new Properties();
        prop.load(fr);
        
        System.out.println("id    : " + prop.getProperty("id"));
        System.out.println("irum  : " + prop.getProperty("irum"));
        System.out.println("phone : " + prop.getProperty("phone"));
        fr.close();
    }
    
    public static void main(String[] args) {
        try {
            new PropertyEx().load();
        } catch (IOException e) {
          
            e.printStackTrace();
        }
    }
}
