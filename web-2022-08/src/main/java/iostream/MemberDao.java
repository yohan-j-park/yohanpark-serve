package iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class MemberDao {
    
    public String fileName = "member.obj";
    List<Data> list = new Vector<Data>();   //
    ObjectOutputStream oos;
    ObjectInputStream ois;
   
    public MemberDao() {
        this.list = read();
    }
    
    public void write(Data d){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            list.add(d);
            oos.writeObject(list);
            oos.flush();
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<Data> read(){ 
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            list = (List<Data>)ois.readObject();
            ois.close();
            fis.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public void modify(Data d){
        // 기존 자료를 다시 read
        read();  // file에 있는 데이터들이 넘어온다.
        // 수정 할 데이터 검색
        int index = list.indexOf(d);
        if(index != -1) {
            list.set(index, d); //자료 갱신
            try {
                FileOutputStream fos = new FileOutputStream(fileName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
                oos.flush();    //데이터가 많을 땐 반드시 flush를 써야한다. 출력 스트림을 비우고 버퍼 된 출력 바이트를 강제로 기록
                oos.close();
                fos.close();
                
            } catch (Exception e) {
              
                e.printStackTrace();
            }
        }
    }
    public void delete(String id){
        /*
         1) for(int i=0; i<list.size(); i++){
             Data d = list.get(i);
             if(d.getId().equals(id)){
                 list.remove(i);
             }
         }
         
         2) Data hashCode(), equals()재정의한 후
         int index = list.indexOf(d);
         list.remove(index);
          */
        read(); // 삭제한 후 최종 결과물로 다시 list를 갱신(여러명이 사용할 경우)
        Data d = new Data();
        d.setId(id);
        
        int index = list.indexOf(d);
        if(index != -1) {
            list.remove(index); //메모리에서만 삭제(실제 파일에선 삭제 X)
            try {   //파일에서도 삭제하는 코드
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
                oos.close();
                fos.close();
            } catch (Exception e) {

                e.printStackTrace();
            }
            
        }
    }
    public void view(){}
    
}
