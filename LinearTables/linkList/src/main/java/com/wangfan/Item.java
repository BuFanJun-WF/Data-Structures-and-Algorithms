package com.wangfan;

/**
 * @author wang fan
 * @date 2024/6/1 11:44
 * @description 多项式元素
 */
public class Item implements Comparable<Item> {
    /** 系数 */
    private double coef;
    /** 指数 */
    private int exp;
    public Item(double c, int e) {
        coef=c;
        exp=e;
    }

    public void add(Item x) {
        if (exp == x.exp) {
            coef += x.coef;
        }
    }

    public String toString(){
        return String.valueOf(coef)+"x^"+exp;
    }


    @Override
    public int compareTo(Item o) {
        if (exp > o.getExp()) {
            return 1;
        }
        else if (exp < o.getExp()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
