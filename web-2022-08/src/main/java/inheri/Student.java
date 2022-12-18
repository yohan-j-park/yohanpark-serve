package inheri;

public class Student extends Data{
   int kor;
   int eng;
   int mat;
   
   public int getKor() {
    return kor;
}

public void setKor(int kor) {
    this.kor = kor;
}

public int getEng() {
    return eng;
}

public void setEng(int eng) {
    this.eng = eng;
}

public int getMat() {
    return mat;
}

public void setMat(int mat) {
    this.mat = mat;
}

public Student(String name, String address, String phone, int kor, int eng, int mat){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }
   

@Override // 어노테이션
   public String toString() {
       String str =  "이 름 : "  + this.name                       + "\n"
                   + "주 소 : "  + this.address                    + "\n"
                   + "연락처 : "  + this.phone                      + "\n"
                   + "국 어 : "  + this.kor                        + "\n"
                   + "영 어 : "  + this.eng                        + "\n"
                   + "수 학 : "  + this.mat                        + "\n"
                   + "총 점 : "  +(this.kor + this.eng + this.mat) + "\n"
                   + "평 균 : "  +(this.kor + this.eng + this.mat) /3 ;
       return str;
   }
   
}
