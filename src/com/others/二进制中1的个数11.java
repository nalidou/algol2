package com.others;


/**
 * 来源：剑指offer 11
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 */
public class 二进制中1的个数11 {
    public static void main(String[] args) {

        int n = 7;
        int sum = 0;
        while (n > 0) {
            System.out.println(n % 2);
            if (n % 2 == 1){
                sum++;
            }
            n = n >> 1;
        }
        System.out.println(sum);

    }
}
