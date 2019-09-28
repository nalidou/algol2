package com.LeetCode.p1;

public class 字符串转换整数08 {

    public static void main(String[] args) {
        String str = "  -21124123 sf fs  f ";
        //System.out.println("-" + str.trim() + "-");
        System.out.println(atoi("-91283472332"));
    }

    static int atoi(String str) {
        str = str.trim();
        if (str == null || str.length()==0) {
            return 0;
        }
        int sign = 1;
        int i = 0;
        if (str.charAt(0) == '+') {
            sign = 1;
            i++;
        }

        if (str.charAt(0) == '-') {
            sign = -1;
            i++;
        }
        long sum = 0;
        for (;i<str.length();i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int)sum * sign;
            }
            sum = sum * 10 + str.charAt(i) - '0';

            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && sum > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;

        }
        return (int)sum * sign;
    }
}
