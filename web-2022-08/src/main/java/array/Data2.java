package array;

public class Data2 implements Comparable<Data2>{
    private String mid;
    private int score;
    
    public Data2(String mid, int score){
        this.mid = mid;
        this.score = score;
    }
    public String getMid() { // getter를 만들면 field 명 mid에서 m이 대문자로 바뀜, 매개변수 사용 못함
        return mid;          // getter: 반출
    }
    public void setMid(String mid) { // setter: 반입
        this.mid = mid;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public int compareTo(Data2 o) {
     // 이름을 오름차순으로
     // int r = this.mid.compareTo(o.mid); // this.mid와 o.mid를 비교하여 this.mid가 더 크면 양수값이 나옴(자리를 바꿈 / 오름차정렬)
     // 성적을 오름차순으로
        int r = this.score - o.score;
     // 이름을 내림차순으로
     // int r = o.mid.compareTo(this.mid);
     // 성적을 내림차순으로
     // int r = o.score - this.score;   
        return r;
//        String a = "abc";
//        String b = "def";
//        int r = b.compareTo(a);
//        
//        return r;
    }
    @Override
    public String toString() {
        String str = "mid:" + this.mid
                    + " , score:" + this.score;
        return str;
    }

}
