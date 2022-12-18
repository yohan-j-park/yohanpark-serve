package lang;

public class MathEx {
    public void test1() {   //Math.ceil():소숫점 이하를 절상
        int value = 12345;
        System.out.println("절상 전: " + (value*0.045));           //555.525
        System.out.println("절상 후: " + Math.ceil(value*0.045));  //556.0
    }
    
    public void test2() {   //Math.floor(): 소숫점이하 절하
        int totAmt = 45450;
        int tax = (int)Math.floor(totAmt/11.0);
        int price = totAmt-tax;
        
        System.out.println(price);      //41319
        System.out.println(tax);        //4131
        System.out.println(price+tax);  //45450
    }
    
    public void test3() {   //1~45
        int r = (int)(Math.random()*45) + 1; // 1~45수 중 랜덤
        System.out.println(r);
    }
    public void test4() {   // Math.round(): 소숫점 이하에서 반올림
        double round1 = 123.556789;
        double round2 = 123.456789;
        
        long round3 = Math.round(round1);   //124
        long round4 = Math.round(round2);   //123
        
        System.out.println(round3);
        System.out.println(round4);
    }
    public static void main(String[] args) {
        MathEx ex = new MathEx();
        ex.test1();
        ex.test2();
        ex.test3();
        ex.test4();
    }
}

