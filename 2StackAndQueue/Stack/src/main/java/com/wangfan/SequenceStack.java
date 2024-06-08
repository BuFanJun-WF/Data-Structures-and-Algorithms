package com.wangfan;

/**
 * @author wang fan
 * @date 2024/6/1 13:49
 * @description 顺序栈
 */
public class SequenceStack<T> {
    final int MaxSize=10;
    private T[] stackArray;
    private int top;
    public SequenceStack( ) {
        top = -1;
        stackArray = (T[])new Object[MaxSize];
    }
    public SequenceStack(int n) {
        if (n <= 0) {
            System .out.println("数组长度要大于0，否则退出程序运行！");
            System.exit(1);
        }
        top = -1;
        stackArray = (T[])new Object[MaxSize];
    }

    // 入栈
    public void push(T obj) {
        if (top==stackArray.length-1) {
            T[] p = (T[]) new Object[top*2+2];
            for(int i=0;i<=top;i++)
                p[i]=stackArray[i];
            stackArray=p;
        }
        top++;
        stackArray[top]=obj;
    }

    //删除栈顶元素
    public T pop() {
        if(top==-1){
            System.out.println("数据栈已空，无法删除元素");
            return null;
        }
        return stackArray[top--];
    }

    //取栈顶数据元素
    public T getHead() {
        if(top==-1){
            System.out.println("数据栈已空，无法删除元素");
            return null;
        }
        return stackArray[top];
    }
    //判断当前栈是否为空
    public boolean isEmpty()  {
        return top==-1;
    }
    //求出栈中数据元素的个数
    public int size(){
        return top+1;
    }
    //依次访问栈中每个元素并输出
    public void nextOrder() {
        for(int i=top;i>=0;i--) {
            System.out.println(stackArray[i]);
        }
    }
    //销毁一个已存在的栈
    public void clear() {
        top=-1;
    }
}
