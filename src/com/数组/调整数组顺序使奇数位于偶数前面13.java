package com.数组;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 调整数组顺序使奇数位于偶数前面13 {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,0,1,3};
        soul(array);
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * 思路1：再新建一个相同大小的数组，第一遍遍历找奇数，放入数组，
     * 第二遍遍历找偶数，放入数组，完成
     * 思路2：
     *   首先，begin从左向右遍历，找到第一个偶数；
     *   然后，from从begin+1开始向后找，直到找到第一个奇数；
     *   接着，将[begin,…,from-1]的元素整体后移一位；
     *   最后将找到的奇数放入begin位置，然后begin++。
     *
     */
    static void soul(int[] array){
        int p = 0;
        int q = 0;
        while (p < array.length) {
            if ((array[p] & 1) == 0) {
                q = p + 1;
                while (q < array.length) {
                    if ((array[q] & 1) == 1) {
                        retio(array, p, q);
                        break;
                    }
                    q++;
                }
            }
            p++;
        }
    }

    //后移
    static void retio(int[] array, int a, int b) {
        int t = array[b];
        for (int i=b; i>a; i--) {
            array[i] = array[i-1];
        }
        array[a] = t;
    }

    static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
