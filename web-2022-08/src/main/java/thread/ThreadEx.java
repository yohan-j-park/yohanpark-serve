package thread;

public class ThreadEx {
    public void test1() {     //Thread
//        System.out.println("thread test start...");
//        T t1 = new T();
//        T t2 = new T();
//        T t3 = new T();
//        t1.start();
//        t2.start();
//        t3.start();
//        System.out.println("thread test end...");
        
}
    public void test2() {   //Runnable
//        R r1 = new R();
//        R r2 = new R();
//        R r3 = new R();
//       
//        Thread t1 = new Thread(r1);
//        Thread t2 = new Thread(r2);
//        Thread t3 = new Thread(r3);
//        Thread t1 = new Thread(new R());
//        Thread t2 = new Thread(new R());
//        Thread t3 = new Thread(new R());
//        
//        System.out.println("Runnable test start..");
//        t1.start();
//        t2.start();
//        t3.start();
//        System.out.println("Runnable test end..");
    }
    public void test3() {   //Daemon Thread
//        T t1 = new T();
//        System.out.println("Main Thread Start...");
//        t1.setDaemon(true);  //Daemon Thread 생성
//        t1.start();
//        
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        
//        System.out.println("Main Thread End...");
 }
    
    public void test4() {   //Join 
        System.out.println("메인 스레드 시작...");
        
        T t1 = new T(); 
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }      
        System.out.println("메인 스레드 종료...");
    }
        
    public static void main(String[] args) {
        new ThreadEx().test4();
    }
}


class T extends Thread{
    @Override
    public void run() {
        for(int i=0; i<200; i++) {
            System.out.print(this.getName() + " ");     
//            try {
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                
//                e.printStackTrace();
//            }
        }
        
        
        System.out.println(); 
         // t1,t2,t3가 같이 실행됨(순서는 랜덤)
    }
    
}

class R implements Runnable{   // run method가 추상메소드라 run method를 재정의하지 않으면 오류뜸

    @Override
    public void run() {
        for(int i=1; i<=200; i++) {
            System.out.printf("%4d",i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println();
    }    
    
}