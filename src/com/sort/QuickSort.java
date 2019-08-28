package com.sort;


import java.util.Arrays;

/**
 * 快速排序
 * https://blog.csdn.net/nrsc272420199/article/details/82587933
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] array = new int[] {3,2,5,7,1,3,8,4,9};
        sort(array, 0, array.length-1);
        for (int a : array) {
            System.out.print(a + " ");
        }
    }

    static void sort(int[] array, int low, int high){
        if (low < high) {
            int index = getIndex(array, low, high);
            //System.out.println(index);
            sort(array, low, index-1);
            sort(array, index+1, high);
        }
    }

    static int getIndex(int[] array, int low, int high){
        int base = array[low];
        int flag = 1;
        while (low < high) {
            if (flag == 1) {
                if (base > array[high]) {
                    array[low] = array[high];
                    flag = 0;
                    continue;
                }
                high--;
            } else {
                if (base < array[low]) {
                    array[high] = array[low];
                    flag = 1;
                    continue;
                }
                low++;
            }
        }
        array[low] = base;
        return low;
    }
}
