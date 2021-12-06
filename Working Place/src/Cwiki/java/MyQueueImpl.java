package Cwiki.java;

import java.util.ArrayList;

public class MyQueueImpl<E> implements MyQueue<E> {

    private ArrayList<E> list;
    private int first, position,size;

    public MyQueueImpl(int size) {
        list = new ArrayList<E>();
        for(int i=0; i<size; i++) list.add(i,null);
        first = position = 0;
        this.size = size;
    }

    private int increment(int current) {
        return current == size ? 0 : current+1;
    }

    @Override
    public void enqueue(E x) throws FullException {
        if(isFull()) throw new FullException("Kolejka pełna!");
        else {list.set(position,x); position = increment(position); }
    }

    @Override
    public void dequeue() {
        if(!isEmpty()) first = increment(first);
    }

    @Override
    public E first() throws EmptyException {
        if(isEmpty()) throw new EmptyException("Kolejka Pusta!");
        else return list.get(first);
    }

    @Override
    public boolean isEmpty() {
        return position == first;
    }

    @Override
    public boolean isFull() {
        return position - first == -1 || position - first == size;
    }
}
