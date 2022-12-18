package iostream;

import java.io.Serializable;
import java.util.Vector;

public class ScoreVo implements Serializable{
    public static long serialVersionUID = 300L;
    int serial, score;
    String id, mDate, subject;
    
    public ScoreVo(int serial, String id, String mdate, String subject, int score) {
        this.serial = serial;
        this.id = id;
        this.mDate = mdate;
        this.subject = subject;
        this.score = score;
    }
    public ScoreVo() {}
    public Vector getVector() {
        Vector v = new Vector();
        v.add(serial);
        v.add(id);
        v.add(mDate);
        v.add(subject);
        v.add(score);
        return v;
    }
// 서로 다른 클래스에서 생성되었어도 같은 데이터라고 인식시키기 위한 재정의
    @Override
    public int hashCode() {

        return this.serial;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        if(obj instanceof ScoreVo) {        //Object가 ScoreVo타입일 때만 비교하겠다.
            ScoreVo vo = (ScoreVo)obj;      
            b = (vo.getSerial() == this.serial);
        }
        return b;
    }
    public int getSerial() {
        return serial;
    }
    public int getScore() {
        return score;
    }
    public String getId() {
        return id;
    }
    public String getmDate() {
        return mDate;
    }
    public String getSubject() {
        return subject;
    }
    public void setSerial(int serial) {
        this.serial = serial;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setmDate(String mDate) {
        this.mDate = mDate;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
