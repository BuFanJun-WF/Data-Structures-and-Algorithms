package com.wangfan;

public class Main {
    public static void main(String[] args) {
        LinkList<Integer> L=new LinkList<Integer>( );
        int i;
        int a[]={23,56,12,49,35};
        for(i=0;i<a.length;i++)
            L.add(a[i], i+1);   //将数组中各元素插入到单链表中
        System.out.println("单链表中的数据元素为：");
        L.nextOrder();
        L.add(30, 4);
        System.out.println("执行插入操作后单链表中的数据元素为：");
        L.nextOrder();
        L.remove(5);
        System.out.println("执行删除操作后单链表中的数据元素为：");
        L.nextOrder();
        i=L.find(12);        //在单链表L中查找元素12的位序
        System.out.println("元素12在单链表中的位序为:"+i);
    }
}