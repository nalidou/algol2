package com.字符串;

/**
 *  来源：剑指offer
 * 将一个字符串转换成一个整数，
 * 要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class 把字符串转换成整数49 {
    public static void main(String[] args) {
        System.out.println(10 + 0.2324);

    }

    static double str2Double(String str){
        String integer = null;
        String decimal = null;
        //检验小数点
        if (str.contains(".")){
            String[] pairs = str.split(".");
            if (pairs[0].contains(".") || pairs[1].contains(".")) {
                return 0.0;
            } else {
                integer = pairs[0];
                decimal = pairs[1];
            }
        } else {
            integer = str;
        }
        //处理整数
        int rate = 10;
        int integerSum = 0;
        int start = 0;
        int flag = 1;
        if (integer.charAt(0) == '-') {
            flag = -1;
            start = 1;
        }else if (integer.charAt(0) == '+') {
            start = 1;
            flag = 1;
        }
        for(int i=integer.length()-1; i>=start; i++) {
            char c = integer.charAt(i);
            int inte = getNum(c);
            int r = integer.length()-1-i;
            int produ = getRate2(rate, r);
            if (inte != -1) {
                integerSum += produ * inte;
            } else {
                return 0;
            }
        }

        return 0.0;
    }

    static int getNum(char c) {
        if (c == '0') {
            return 0;
        }
        if (c == '1') {
            return 1;
        }
        if (c == '2') {
            return 2;
        }
        if (c == 3) {
            return 3;
        }
        if (c == '4') {
            return 4;
        }
        if (c == '5') {
            return 5;
        }
        if (c == '6') {
            return 6;
        }
        if (c == '7') {
            return 7;
        }
        if (c == '8') {
            return 8;
        }
        if (c == '9') {
            return 9;
        }
        return -1;
    }

    static int getRate2(int rate, int n){
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return rate;
        }
        int sum = rate;
        for (int i=2;i<=n;i++) {
            sum = sum * rate;
        }
        return sum;
    }

}
