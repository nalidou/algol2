package com.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 来源：剑指offer 45
 * 满足如下条件才可以认为是顺子：
 *
 * 输入数据个数为5；
 * 输入数据都在0-13之间；
 * 没有相同的数字；
 * 最大值与最小值的差值不大于5。
 * PS：大小王可以当成任意数。
 */
public class 扑克牌顺子45 {

    public static void main(String[] args) {
        int[] array = new int[]{2,1,3,5,4};
        int[] array2 = new int[]{2,1,3,5,5};
        System.out.println(isContinuous(array2));
    }

    static boolean isContinuous(int[] array){
        if (array==null || array.length < 5) {
            return false;
        }
        int max = array[0];
        int min = array[0];
        Map map = new HashMap();
        for (int item : array) {
            System.out.println(item);
            if (item < 0 || item > 13) {
                return false;
            }
            if (item == 0) {
                continue;
            }
            if (map.containsKey(item)) {
                return false;
            }
            map.put(item,1);
            if (item > max) {
                max = item;
            }
            if (item < min) {
                min = item;
            }
            if (max - min >= 5) {
                return false;
            }
        }
        return true;
    }
}
