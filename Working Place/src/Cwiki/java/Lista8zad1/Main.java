package Cwiki.java;

public class Main {

    public static void main(String[] args) throws FullException, EmptyException {
        MyQueue<Integer> queue = new MyQueueImpl<>(3);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.isEmpty()==false);
        System.out.println(queue.isFull()==true);
        System.out.println(queue.first()==2);
        queue.dequeue();
        System.out.println(queue.first()==3);
        queue.dequeue();
        System.out.println(queue.first()==4);

    }

}
