package json;

public class Test {
    String irum;
    int score;
    
    
    
    public Test(String irum, int score) {
       
    }
    @Override // 재정의
    public String toString() {
       String p = "{'irum' : '%s' , 'score' : '%d'}";
       String str = 
               String.format(p, this.irum, this.score);
       str = str.replace("'", "\"");
        return super.toString()+ "\n" + str;  // super : 부모 대상  this: 자신 대상
    }
    public String getIrum() {
        return irum;
    }
    public void setIrum(String irum) {
        this.irum = irum;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
