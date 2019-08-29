package com.others;

/**
 * 来源：剑指offer 29
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 *
 * 方法一：直接排序，然后输入k个数
 * 方法二：如下
 */
public class 最小的K个数29 {
    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,2,7,3,8};
        int[] mins = new int[3];

        for (int i=0; i<array.length; i++) {
            if (i < 3) {
                mins[i] = array[i];
            } else {
                int n = array[i];
                int maxIndex = getMaxIndex(mins);
                if (n < mins[maxIndex]) {
                    mins[maxIndex] = n;
                }
            }
        }
        for (int a : mins) {
            System.out.print(a + " ");
        }
    }

    static int getMaxIndex(int[] mins){
        int max = 0;
        int index = 0;
        for(int i=0; i<mins.length; i++) {
            if (mins[i] > max) {
                max = mins[i];
                index = i;
            }
        }
        return index;
    }


}
