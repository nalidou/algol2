package com.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 来源：剑指offer 41
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，
 * 序列间按照开始数字从小到大的顺序。
 */
public class 和为S的连续正数序列41 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i=0;i<100;i++) {
            array[i] = i+1;
        }
        System.out.println(findTowNum(array, 100));
    }

    static List findTowNum(int[] array, int s){
        if (array == null || array.length == 0 || s < 0){
            return null;
        }
        List<String> list = new ArrayList<>();
        int start = 1;
        int end = 2;
        while (start < end) {
            int item1 = array[start];
            int item2 = array[end];
            int res = (item1 + item2) * (end-start+1) >> 1;
            if (res == s) {
                list.add(item1 + "->" + item2);
                start++;
            } else if (res < s) {
                end++;
            } else if (res > s) {
                start++;
            }
        }
        return list;
    }
}
