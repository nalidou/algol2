package com.others;

/**
 *  来源：剑指offer 31
 *  输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 *  例如输入12，从1到12这些整数中包含1的数字有1，10，11和12，1一共出现了5次。
 */
public class 从1到n整数中1出现的次数31 {

    public static void main(String[] args) {

        int n = 12;
        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum+=getOne(i);
        }
        System.out.println("sum: " + sum);
    }

    static int getOne(int num){
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int n = 0;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == '1') {
                n++;
            }
        }
        System.out.println(num + " : " + n);
        return n;
    }


}
