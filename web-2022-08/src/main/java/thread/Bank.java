package thread;

public class Bank {
    int amt = 10000;
    public synchronized void output(String n, int a) {      // 특히 금융거래에선 synchronized(동기화)가 필수적이다.
        if(amt>=a) {
            try {
                Thread.sleep(100);
                amt -= a;
            } catch (InterruptedException e) {              
                e.printStackTrace();
            }
        }
        
        System.out.print(n + " >>> ");
        System.out.printf("출금:%5d, 잔액:%5d\n",a,amt);
    }
}
