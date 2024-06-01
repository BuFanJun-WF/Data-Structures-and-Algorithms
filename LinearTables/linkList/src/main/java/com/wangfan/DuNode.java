package com.wangfan;

/**
 * @author wang fan
 * @date 2024/6/1 11:12
 * @description 双向链表Node
 */
public class DuNode<T> {
    T data;
    DuNode<T> prior;
    DuNode<T> next;
    public DuNode(DuNode<T> n){
        next=n;
        prior=null;
    }
    public DuNode(T obj,DuNode<T> n, DuNode<T> p){
        data=obj;
        next=n;
        prior=p;
    }
}
