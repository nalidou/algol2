package com.LeetCode.p1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class 整数反转07 {
    public static void main(String[] args) {

        int a = 123;
        int b = -123;
        int c = 1234567895;
        int d = -123000;
        int e = -1534236469;
        System.out.println(reverse(e));

    }

    public static int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = -x;
        }

        int y = x;
        int n = 1;
        List<Integer> list = new ArrayList<>();
        while (y > 0) {
            int a = y / 10;
            int b = y % 10;
            list.add(b);
            y = a;
            n = n * 10;
            System.out.println("--> " + n);
        }
        System.out.println(list);
        System.out.println("n: " + n);
        return 0;
    }


}
