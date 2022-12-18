package jsp;

public class BeanTestVo2 {
    String id;
    int kor;
    int eng;
    int mat;
    int tot;
    double avg;
    
//    public int tot() {
//        tot = kor+eng+mat; 
//        
//        return tot;
//    }
//    
//    public double avg() {
//        avg = tot/3.0d;
//        
//        return avg;
//    }

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
    public int getTot() {
       tot=eng+kor+mat;
        return tot;
    }
    public double getAvg() {
        avg = tot/3.0d;
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
    public void setTot(int tot) {
        this.tot = tot;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
        
}
