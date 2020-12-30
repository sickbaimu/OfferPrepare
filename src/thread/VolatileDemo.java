package thread;

public class VolatileDemo {
    //public static int found = 0;//volatile
    public static volatile int found = 0;

    public static void main(String[] args) {
        new Thread(new Runnable(){
            public void run(){
                System.out.println("等另一个线程找资源");
                while(found==0){

                }
                System.out.println(Thread.currentThread().getName()+"资源送到了，开始运行。");
            }
        },"运行线程").start();
        new Thread(new Runnable(){
            public void run(){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"找到资源了，开始送。");
                found = 1;
            }
        },"寻找线程").start();
    }

}
