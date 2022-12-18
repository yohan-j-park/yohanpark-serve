package iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class ScoreDao implements ScoreInterface{
    String fileName = "score.obj";
    List<ScoreVo> list = new Vector<ScoreVo>();
    
    public ScoreDao() {
        list = read();
    }
    

    @Override
    public void write(ScoreVo vo) {
        try {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        list.add(vo);
        oos.writeObject(list); 
        oos.flush();
        oos.close();
        fos.close();
        
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<ScoreVo> read() {
        try {
            //score.obj파일의 유무 체크
            File f = new File(fileName);
            if(f.exists()) {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<ScoreVo>)ois.readObject();
            
            ois.close(); 
            fis.close();
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void modify(ScoreVo vo) {
        // list를 최신정보로 갱신
        this.list = read();
        
        // vo객체를 검색
        int index = list.indexOf(vo);
        //hashCode를 재정의하지 않으면 검색을 하지 못함
        // index번째 내가 찾는 serial번호가 있는지
        

        // 수정
        list.set(index, vo);    
        
        //파일에 저장
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            
            oos.flush();
            oos.close();
            fos.close();
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int serial) {
        list = read();
        ScoreVo vo = new ScoreVo();
        vo.setSerial(serial);
        int index = list.indexOf(vo);
        if(index != -1) {
            list.remove(index);
            
            try {
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(list);
                oos.flush();
                oos.close();
                fos.close();
                
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        
    }

}
