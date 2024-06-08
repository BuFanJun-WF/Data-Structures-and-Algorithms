package com.wangfan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wang fan
 * @date 2024/6/1 23:09
 * @description TODO
 */
public class chap3_2 {
    /**
     * 括号匹配
     * @param exp 输入表达式子
     * @return 是否匹配成功
     */
    public static boolean matching(char []exp) {
        int state = 1, i = 0;
        SequenceStack<Character> s = new SequenceStack<>();
        while (i < exp.length && state == 1) {
            switch (exp[i]) {
                case '[':
                case '(': {
                    s.push(exp[i]);
                    i++;
                    break;
                }
                case ']': {
                    if (!s.isEmpty()) {
                        if (s.getHead() == ']') {
                            s.pop();
                            i++;
                        }
                        else {
                            state = 0;
                        }
                    }
                    else {
                        state = 0;
                    }
                    break;
                }
                case ')': {
                    if (!s.isEmpty()) {
                        if (s.getHead()=='(') {
                            s.pop();
                            i++;
                        }
                        else {
                            state = 0;
                        }
                    }
                    else {
                        state = 0;
                    }
                    break;
                }

                default:{
                    i++;
                    break;
                }
            }
        }
        if (s.isEmpty() && state == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    

    public static void main(String[] args) {
        BufferedReader br;
        String s;
        char[] us;
        try{
            br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("输入一个含有（ ）和[]的表达式：");
            s=br.readLine();
            us=s.toCharArray();
            if(matching(us))
                System.out.println("表达式中括号匹配");
            else
                System.out.println("表达式中括号不匹配");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
