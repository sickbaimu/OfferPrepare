package structure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueDemo {
//优先队列自然排序示例

    public static void main(String[] args) {
        //优先队列使用示例
        Queue<Customer> queue = new PriorityQueue<>(7, idComparator);
        //添加数据
        Random rand = new Random();
        for(int i=0; i<7; i++){
            int id = rand.nextInt(100);
            queue.add(new Customer(id, "NoName " + id));
        }
        //取数据
        while(true){
            Customer customers = queue.poll();
            if(customers == null)
                break;
            System.out.println("Processing Customer with ID="+customers.getId());
        }
    }

    //匿名Comparator实现
    public static Comparator<Customer> idComparator = new Comparator<>() {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.getId() - c2.getId();
        }
    };

    static class Customer {
        private final int id;
        private final String name;
        public Customer(int i, String n){
            this.id=i;
            this.name=n;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
    }
}
