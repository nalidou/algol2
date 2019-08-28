package com.others;


/**
 * 来源：剑指offer 48
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class 不用加减乘除的加法48 {

    public static void main(String[] args) {
        System.out.println(add(45,7));
    }

    static int add(int unit, int decade) {
        if (decade == 0) {
            return unit;
        }
        int new_unit = unit ^ decade;//求个位是两数异或
        int new_decade = (unit & decade) << 1;//求十位是两数相与，再左移位1步
        System.out.println(new_unit + "  " + new_decade);
        return add(new_unit, new_decade);
    }
}
