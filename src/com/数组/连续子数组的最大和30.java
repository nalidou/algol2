package com.数组;

/**
 *下图是我们计算数组（1，-2，3，10，-4，7，2，-5）中子数组的最大和的过程。
 * 通过分析我们发现，累加的子数组和，如果大于零，那么我们继续累加就行；
 * 否则，则需要剔除原来的累加和重新开始。
 *
 */
public class 连续子数组的最大和30 {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,4,-1,-2,5,-1,8,-9};
        System.out.println(sum(array));
    }
    static int sum(int[] array) {
        int sum = array[0];
        int cur = array[0];
        for (int i=1;i<array.length;i++) {
            int n = array[i];
            if (cur <= 0) {
                cur = n;
            } else {
                cur = cur + n;
            }
            if (cur > sum) {
                sum = cur;
            }

        }

        return sum;
    }
}
