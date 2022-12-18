package iostream;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Score implements Serializable {
    public static long serialVersionUID = 200L;
    private String id;
    private int kor;
    private int eng;
    private int mat;
    private double tot;
    private double avg;
    
    Score(String id, int kor, int eng, int mat){
        this.id = id;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
        
        this.tot = (kor+eng+mat);
        this.avg = tot/3.0d;
        
    }
    public String getId() {
        return id;
    }
    public int getKor() {
        return kor;
    }
    public int getEng() {
        return eng;
    }
    public int getMat() {
        return mat;
    }
    public double getTot() {
        return tot;
    }
    public double getAvg() {
        return avg;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setKor(int kor) {
        this.kor = kor;
    }
    public void setEng(int eng) {
        this.eng = eng;
    }
    public void setMat(int mat) {
        this.mat = mat;
    }
    public void setTot(double tot) {
        this.tot = tot;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    @Override
    public String toString() {
        DecimalFormat sdf = new DecimalFormat("#,###.00");
        
        String str = "\n---------------" + "\n"
                    +" id : " + this.id  + "\n"
                    +"kor : " + this.kor + "\n"
                    +"eng : " + this.eng + "\n"
                    +"mat : " + this.mat + "\n"
                    +"tot : " + this.tot + "\n"
                    +"avg : " + sdf.format(this.avg);
        
        return str;
    }
}

