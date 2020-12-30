package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
    static class Task implements Runnable{
        private final int nov;
        public Task(int i){
            this.nov = i;
        }
        public void run(){
            System.out.println("当前执行的线程是："+Thread.currentThread().getName());
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("任务："+nov+"正在执行。");
        }
    }
    public static void main(String[] args) {
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,//核心线程数
                3,//最大同时处理线程数，超出核心线程数的非核心线程数
                60,//停留时间数值
                TimeUnit.SECONDS,//停留时间单位
                new ArrayBlockingQueue<>(5),//阻塞队列
                Executors.defaultThreadFactory());//拒绝处理策略，默认即按抛出异常处理
        for(int i=0;i<9;i++)
            pool.execute(new Task(i));
        pool.shutdown();
    }
}


