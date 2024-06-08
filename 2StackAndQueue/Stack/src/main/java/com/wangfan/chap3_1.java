package com.wangfan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wang fan
 * @date 2024/6/1 23:09
 * @description TODO
 */
public class chap3_1 {
    /**
     * 数值转化
     * @param N 整数
     * @param r 转化进制
     */
    public static void conversion(int N, int r) {
        SequenceStack<Integer> s = new SequenceStack<>();
        while (N!=0) {
            s.push(N%r);
            N = N/r;
        }
        System.out.println("转换结果为：");
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }



    public static void main(String[] args) {
        BufferedReader br;
        Integer num,radix;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("输入一个十进制整数：");
            num=Integer.parseInt(br.readLine());
            System.out.print("转换进制：");
            radix=Integer.parseInt(br.readLine());
            conversion(num,radix);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
