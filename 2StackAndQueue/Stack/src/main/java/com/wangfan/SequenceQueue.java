package com.wangfan;

/**
 * @author wang fan
 * @date 2024/6/1 18:04
 * @description 顺序队列
 */
public class SequenceQueue<T> {
    final int MaxSize = 10;
    private T queueArray[];
    private int front,rear;

    public SequenceQueue() {
        front = rear =0;
        queueArray = (T[]) new Object[MaxSize];
    }

    /**
     * 入队
     * @param obj 对象
     */
    public void enQueue(T obj) {
        // 队列空间已满
        if ((rear + 1) % queueArray.length == front) {
            // 队列进行扩容
            T[] p=(T[])new Object[queueArray.length*2];
            // 队尾指针刚刚好设置在队尾处
            if (rear == ((T[])queueArray).length-1) {
                for (int i = 1; i <= rear; i++) {
                    p[i] = queueArray[i];
                }
            }
            // 队尾指针未在队尾处
            else {
                int i, j =1;
                // 队列已满的时候，对头到队列长度尾处
                for (i=front+1; i<queueArray.length; i++,j++) {
                    p[j] = queueArray[i];
                }
                // 从i开始到队尾指针
                for (i=0; i<=rear; i++,j++) {
                    p[j] = queueArray[i];
                }
                front = 0;
                rear = queueArray.length - 1;
            }
            queueArray = p;
        }
        // 队列空间未满
        rear = (rear + 1) % queueArray.length;
        queueArray[rear] = obj;
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("队列已空，无法出队！");
            return null;
        }
        front = (front + 1) % queueArray.length;
        return queueArray[front];
    }

    public T GetTop() {
        if(isEmpty()){
            System.out.println("队列已空，无法读取元素！");
            return null;
        }
        return queueArray[(front+1)%queueArray.length];
    }

    public boolean isEmpty( ) {
        return front==rear;
    }
    public int size() {
        return (rear-front+queueArray.length)%queueArray.length;
    }

    public void nextOrder() {
        int i,j=front;
        for(i=1;i<=size();i++)
        {
            j=(j+1)%queueArray.length;
            System.out.println(queueArray[j]);
        }
    }

    public void clear() {
        front=rear=0;
    }
}
