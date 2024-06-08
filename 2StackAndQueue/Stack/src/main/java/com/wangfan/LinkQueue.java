package com.wangfan;

/**
 * @author wang fan
 * @date 2024/6/1 19:39
 * @description 链队列
 */
public class LinkQueue<T> {
    private Node<T> front,rear;
    private int length;

    public LinkQueue() {
        length = 0;
        front = rear =new Node<T>(null);
    }

    public void enQueue(T obj) {
        rear = rear.getNext();
        rear.setNext(new Node<T>(obj, null));
        length++;
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，无法出队！");
            return null;
        }
        Node<T> p = front.getNext();
        T x = p.getData();
        front.setNext(p.getNext());
        length--;
        if (front.getNext() == null) {
            rear = front;
        }
        return x;
    }


    public int size() {
        return length;
    }

    public boolean isEmpty( ) {
        return front.getNext()==null;
    }

    public void nextOrder()
    {
        Node<T> p=front.getNext();
        while(p!=null){
            System.out.println(p.getData());
            p=p.getNext();
        }
    }

    public void clear() {
        front.setNext(null);
        rear.setNext(null);
    }
}
