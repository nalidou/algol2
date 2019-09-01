package com.递归;


/**
 * 来源：剑指offer 20
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。（n<=39）
 */
public class 裴波那契数列07 {

    public static void main(String[] args) {

    }

    //方法1，递归不好
    static int getN(int n){
        if (n < 2) {
            return n;
        }
        return getN(n-1) + getN(n-2);
    }

    //方法2，循环来做
    static int Fibonacci(int n) {
        if(n <= 0)
            return 0;
        if(n == 1)
            return 1;
        int first = 0, second = 1, third = 0;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }


}
