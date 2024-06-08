package com.wangfan;

/**
 * @author wang fan
 * @date 2024/6/1 9:36
 * @description 链表节点
 */
public class Node<T> {
    private T data;

    private Node<T> next;

    public Node(Node<T> n){
        next=n;
    }
    public Node(T obj, Node<T> n){
        data=obj;
        next=n;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData(  ) {
        return data;
    }

    public Node<T> getNext(  ){
        return next;
    }
}
