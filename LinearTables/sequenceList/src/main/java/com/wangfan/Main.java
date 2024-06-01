package com.wangfan;

/**
 * @author wang fan
 * @date 2024/5/31 12:29
 * @description TODO
 */
public class Main {
    public static void main(String[] args) {
        SequenceList<Integer> L = new SequenceList<>();
        int status,e,i;
        int []a={23,56,12,49,35};
        for (i = 0; i < a.length; i++) {
            L.add(a[i], i+1);
        }
        System.out.print("顺序表中的数据元素为：");
        L.nextOrder();
        L.add(30, 4);
        System.out.print("执行插入操作后顺序表中的数据元素为：");
        L.nextOrder();
        e=L.remove(5);
        System.out.print("执行删除操作后顺序表中的数据元素为：");
        L.nextOrder();
        i=L.find(12);        //在顺序表L中查找元素12的位序
        System.out.println("元素12在线性表中的位序为:"+i);
    }
}
