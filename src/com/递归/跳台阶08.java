package com.递归;


/**
 * 来源：剑指offer 08
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。（n<=39）
 */
public class 跳台阶08 {

    public static void main(String[] args) {


    }

    static int getN(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        return getN(n-1) + getN(n-2);
    }

    static int getN2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int n1 = 1, n2 = 2;
        int n3 = 0;
        for (int i=3; i<n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

}
