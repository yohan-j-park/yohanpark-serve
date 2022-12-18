package score;

public class ScoreVo {
    int serial=0;
    String id="";
    String mdate="";
    String subject="";
    int score=0;
      
    public int getSerial() {
        return serial;
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
    public int getScore() {
        return score;
    }
    public void setSerial(int serial) {
        this.serial = serial;
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
    public void setScore(int score) {
        this.score = score;
    }
}
