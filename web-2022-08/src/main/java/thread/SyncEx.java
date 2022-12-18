package thread;

public class SyncEx {
    public static Bank b = new Bank();
    public SyncEx() {
        for(int i=0; i<200; i++) {
            OutThread ot = new OutThread();
            ot.start();
        }
    }
    public static void main(String[] args) {
        new SyncEx();
    }
    class OutThread extends Thread {
        public void run() {
            int amt = (int)(Math.random()*100);
            b.output(this.getName(), amt);
        }
    }
}