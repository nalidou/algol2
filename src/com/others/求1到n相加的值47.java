package com.others;

/**
 * 来源：剑指offer 47
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class 求1到n相加的值47 {

    public static void main(String[] args) {

        System.out.println(sum(4));
    }

    static int sum(int n){
        if (n == 1) {
            return n;
        }
        return sum(n-1) + n;
    }

}
