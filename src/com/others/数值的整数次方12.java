package com.others;

/**
 * 来源：剑指offer 12
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class 数值的整数次方12 {

    public static void main(String[] args) {
        double base = 10.02D;
        int exponent = -3;

        System.out.println(getResult(base, exponent));

    }

    static double getResult(double base, int exponent) {
        if (base == 0.0) {
            return base;
        }
        if (exponent == 0) {
            return 1;
        }
        double result = 0.0D;
        result = base * base;
        for (int i=2; i<Math.abs(exponent); i++) {
            result = base * result;
        }
        if ((exponent < 0) && (exponent % 2 != 0)) {
            result = 1 / result;
            return result;
        } else {
            return result;
        }
    }


}
