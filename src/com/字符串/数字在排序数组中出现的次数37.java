package com.字符串;


/**
 *统计一个数字在排序数组中出现的次数。
 *
 * https://www.cnblogs.com/tongkey/p/7816778.html
 */
public class 数字在排序数组中出现的次数37 {

    public static void main(String[] args) {
        int k=3;
        int[] array = new int[]{1,2,3,3,3,3,4,5};
        int index = get(array, 0, array.length-1, k);
        //int start = get(array, 0, index-1, k);
        //int end = get(array, index+1, array.length-1, k);
        //System.out.println(index + " " + start + " " + end);

    }

    static int get(int[] array, int start, int end, int k) {

        int mid = (end-start) >> 1;

        if (array[mid] == k) {
            return mid;
        } else if (array[mid] > k){
            end = mid - 1;
            return get(array, start, end, k);
        } else {
            start = mid + 1;
            return get(array, start, end, k);
        }
    }
}
