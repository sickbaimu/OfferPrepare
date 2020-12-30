package thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock测试类
 */
public class ReentrantLockDemo {
    static ReentrantLock reentrantlock = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                output();
            }
        };
        t1.setName("t1");
        Thread t2 = new Thread(){
            @Override
            public void run(){
                output();
            }
        };
        t2.setName("t2");
        t1.start();
        t2.start();
    }
    public static void output(){
        reentrantlock.lock();
        System.out.println(Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            reentrantlock.unlock();
        }
    }
}
