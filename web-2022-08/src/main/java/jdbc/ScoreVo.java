package jdbc;

public class ScoreVo {
    int serial, score;
    String id, mdate, subject;
    
    public ScoreVo(int serial, String id, String subject, int score) {
        this.serial = serial;
        this.id = id;
        this.subject = subject;
        this.score = score;
    }
    public ScoreVo() {}
    public int getSerial() {
        return serial;
    }
    public int getScore() {
        return score;
    }
    public String getId() {
        return id;
    }
    public String getMdate() {
        return mdate;
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
    public void setMdate(String mdate) {
        this.mdate = mdate;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}

