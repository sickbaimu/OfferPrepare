package thread;

/**
 * Synchronized关键字测试类
 */
public class SynchronizedDemo {
    int lock = 1;
    public static void main(String[] args) {
        SynchronizedDemo test = new SynchronizedDemo();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                test.lockFun();
            }
        };
        t1.setName("t1");
        Thread t2 = new Thread(){
            @Override
            public void run(){
                test.lockFun();
            }
        };
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    /**
     * 1. 锁方法
     */
    public synchronized void lockFun(){
        System.out.println(Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 2. 锁代码块
     */
    public void lockCodeBlock(){
        synchronized(this){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 3. 锁变量
     */
    public void lockVariable(){
        synchronized((Object)lock){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 4. 锁类
     */
    public void lockClass(){
        synchronized(SynchronizedDemo.class){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
