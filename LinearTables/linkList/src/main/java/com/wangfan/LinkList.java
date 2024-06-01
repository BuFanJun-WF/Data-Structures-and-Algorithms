package com.wangfan;

/**
 * @author wang fan
 * @date 2024/6/1 9:40
 * @description 链表
 */
public class LinkList<T> {
    private Node<T> head;
    private int length;

    public LinkList(){
        length = 0;
        head = new Node<T>(null);
    }

    public Node<T> getHead() {
        return head;
    }

    /**
     * 单链表添加
     * @param obj 对象
     * @param pos 位置
     * @return 返回添加是否成功
     */
    public boolean add(T obj, int pos) {
        if((pos<1||pos>length+1)){
            System.out.println("pos值不合法");
            return false;
        }
        int num = 1;
        Node<T> p = head, q = head.getNext();
        while (num < pos) {
            p = q;
            q = q.getNext();
            num++;
        }
        p.setNext(new Node<T>(obj, q));
        length++;
        return true;
    }

    /**
     * 单链表删除
     * @param pos 位置
     * @return 返回删除的元素
     */
    public T remove(int pos) {
        if(isEmpty( )){
            System.out.println("链表为空表");
            return null;
        }
        else {
            if((pos<1||pos>length+1)){
                System.out.println("pos值不合法");
                return null;
            }
            int num = 1;
            Node<T> p = head, q = head.getNext();
            while (num < pos) {
                p = q;
                q = q.getNext();
                num++;
            }
            p.setNext(q.getNext());
            length--;
            return q.getData();
        }
    }

    /**
     * 单链表的查找
     * @param obj 对象
     * @return 返回查找到的位置
     */
    public int find(T obj) {
        if(isEmpty( )){
            System.out.println("链表为空表");
            return -1;
        }
        int num = 1;
        // 获取头节点引用的节点
        Node<T> p = head.getNext();
        while (p != null) {
            if (!p.getData().equals(obj)) {
                p = p.getNext();
                num++;
            }
            else {
                break;
            }
        }
        if (p == null) {
            return -1;
        }
        return num;
    }

    /**
     * 获取单链表第pos个结点的值
     * @param pos 位置
     * @return 返回值
     */
    public T value(int pos) {
        if(isEmpty()){
            System.out.println("链表为空表");
            return null;
        }
        else {
            if((pos<1||pos>length+1)){
                System.out.println("pos值不合法");
                return null;
            }
            int num = 1;
            Node<T> q = head.getNext();
            while (num < pos) {
                q = q.getNext();
                num++;
            }
            return q.getData();
        }
    }

    /**
     * 更新单链表第pos个结点的值
     * @param obj 结点
     * @param pos 位置
     * @return 返回更新是否成功
     */
    public boolean modify(T obj, int pos) {
        if(isEmpty( )){
            System.out.println("链表为空表");
            return false;
        }
        else {
            if((pos<1||pos>length+1)){
                System.out.println("pos值不合法");
                return false;
            }
            int num = 1;
            Node<T> q = head.getNext();
            while (num < pos) {
                q = q.getNext();
                num++;
            }
            q.setData(obj);
            return true;
        }
    }

    public int size( ){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void nextOrder(){
        Node<T> p=head.getNext();
        while(p!=null){
            System.out.print(p.getData());
            System.out.print(",");
            p=p.getNext();
        }
        System.out.println();
    }

    public void clear( ){
        length=0;
        head.setNext(null);
    }

}
