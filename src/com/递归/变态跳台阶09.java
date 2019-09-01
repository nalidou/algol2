package com.递归;


/**
 * 剑指offer 09
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 变态跳台阶09 {

    public static void main(String[] args) {

        System.out.println(getN(6));
    }

    static int getN(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        }
        int result = 0;
        for (int i=0; i<n; i++) {
            result = result + getN(i);
        }
        return result + 1;

    }

    static int jumpFloorII(int number) {
        if(number == 0){
            return 0;
        }
        int total = 1;
        for(int i = 1; i < number; i++){
            total *= 2;
        }
        return total;
    }



}
