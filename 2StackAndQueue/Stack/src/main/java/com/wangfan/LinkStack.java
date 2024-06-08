package com.wangfan;


/**
 * @author wang fan
 * @date 2024/6/1 13:58
 * @description 链栈
 */
public class LinkStack<T> {
    private Node<T> top;
    private int length;

    public LinkStack() {
        length = 0;
        top = null;
    }

    public void push(T obj) {
        top = new Node<T>(obj, top);
        length++;
    }

    public T pop() {
        if(top==null){
            System.out.println("栈已空，无法删除元素！");
            return null;
        }
        T x = top.getData();
        top = top.getNext();
        length--;
        return x;
    }

    public T getHead() {
        if(top==null){
            System.out.println("栈已空，无法读取元素！");
            return null;
        }
        return top.getData();
    }

    public int size() {
        return length;
    }
    public boolean isEmpty(){
        return top==null;
    }
    public void nextOrder() {
        Node<T> p=top;
        while(p!=null){
            System.out.println(p.getData());
            p=p.getNext();
        }
    }
    public void clear(){
        top=null;
    }


}
