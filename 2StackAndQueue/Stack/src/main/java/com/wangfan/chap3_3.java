package com.wangfan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wang fan
 * @date 2024/6/8 15:53
 * @description 表达式求值
 */
public class chap3_3 {
    /**
     * 用于判断字符c是运算符还是操作符
     * @param c 字符
     * @return 返回是否为运算符
     */
    public static boolean isOperator(char c) {
        return switch (c) {
            case '#', '+', '-', '*', '/', '(', ')' -> true;
            default -> false;
        };
    }

    static char[][] OP = {
            {'>', '>', '<', '<', '<', '>', '>'},
            {'>', '>', '<', '<', '<', '>', '>'},
            {'>', '>', '>', '>', '<', '>', '>'},
            {'>', '>', '>', '>', '<', '>', '>'},
            {'<', '<', '<', '<', '<', '=', 'E'},
            {'>', '>', '>', '>', 'E', '>', '>'},
            {'<', '<', '<', '<', '<', 'E', '='}
    };

    /**
     * 判断操作符的限制Id
     * @param Operator 操作符
     * @return 返回归属Id
     */
    public static int GetOperatorID(char Operator) {
        int retCode;
        retCode = -1;
        retCode = switch (Operator) {
            case '+' -> 0;
            case '-' -> 1;
            case '*' -> 2;
            case '/' -> 3;
            case '(' -> 4;
            case ')' -> 5;
            case '#' -> 6;
            default -> retCode;
        };
        return(retCode);
    }

    /**
     * 判断两个操作符的顺序之前
     * @param Operator1 操作符1
     * @param Operator2 操作符2
     * @return 返回操作符的优先级
     */
    public static char precede(char Operator1, char Operator2) {
        int OperatorID1, OperatorID2;
        OperatorID1=GetOperatorID(Operator1);
        OperatorID2=GetOperatorID(Operator2);
        if (OperatorID1<0||OperatorID1>6||OperatorID2<0||OperatorID2>6)
            return ('E');
        return(OP[OperatorID1][OperatorID2]);
    }
    //operate（ ）将以op1、op2作为第一、二操作数
    //theta作为运算符进行计算，返回计算结果
    public static double operate(double op1,char cal,double op2) {
        return switch (cal) {
            case '+' -> op1 + op2;
            case '-' -> op1 - op2;
            case '*' -> op1 * op2;
            case '/' -> op1 / op2;
            default -> 0;
        };
    }

    /**
     * 输入表达式然后返回计算结果
     * @param exp 表达式
     * @return 计算结果
     */
    public static double expEvaluation(char[] exp) {
        char thera;
        int i=0;
        double b,a,val;
        SequenceStack<Character> OPTR = new SequenceStack<Character>(); //运算符栈
        SequenceStack<Double> OPND = new SequenceStack<Double>();        //操作数栈
        OPTR.push('#');
        // 如果表达式以#结束，则跳过
        while (exp[i] != '#' || OPTR.getHead() != '#') {
            // 如果是操作数，则压入操作数栈
            if (!isOperator(exp[i])) {
                double temp;
                // 将字符转化为十进制数
                temp=exp[i]-'0';
                i++;
                /*将逐个读入的操作数各位转化为十进制数*/
                while (i<exp.length && !isOperator(exp[i])) {
                    temp = temp*10 + (exp[i]-'0');
                    i++;
                }
                OPND.push(temp);
            }
            // 如果是操作符，进行以下判断
            else {
                /* preced()用于判断栈顶元素和表达式当前元素的优先级 */
                /*，返回’<’表、’>’、’=’ */
                switch (precede(OPTR.getHead(),exp[i])) {
                    // 栈顶元素优先级低，入栈
                    case '<' :
                        OPTR.push(exp[i]);
                        i++;
                        break;
                    /*优先权相等，脱括号并接收下一字符*/
                    case '=' :
                        OPTR.pop();
                        i++;
                        break;
                    // 栈顶元素优先级高，进行计算
                    case '>' :
                        thera=OPTR.pop();
                        b=OPND.pop();
                        a=OPND.pop();
                        OPND.push(operate(a, thera,b));
                        break;
                }
            }

        }
        val = OPND.getHead();
        return val;

    }


    public static void main(String[] args) {
        BufferedReader br;
        String s;
        try{
            br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("输入一个以#结束的表达式：");
            s=br.readLine();
            char[] us=s.toCharArray();
            System.out.println("表达式值为："+ expEvaluation(us));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
