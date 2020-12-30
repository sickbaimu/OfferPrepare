package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    //private int a = 0;
    private AtomicInteger a = new AtomicInteger(0);

    public int add(){
        return a.getAndIncrement();
        //return a++;
    }
    public static void main(String[] args) {
        AtomicDemo test = new AtomicDemo();
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   " + test.add());
                }
            }
        }).start();

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   " + test.add());
                }
            };
        }.start();

    }
}
