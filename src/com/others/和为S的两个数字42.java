package com.others;

/**
 * 来源：剑指offer 42
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class 和为S的两个数字42 {

    public static void main(String[] args) {
        int [] array = new int[] {1,2,3,4,5,6,7,8};
        //System.out.println(findTowNum01(array, 9));
        System.out.println(findTowNum02(array, 9));
    }

    //优化实现，这么做的好处是，也保证了乘积最小。
    static String findTowNum02(int[] array, int s){
        if (array == null || array.length == 0 || s < 0){
            return "null-null";
        }
        int start = 0;
        int end = array.length-1;
        while (start < end) {
            int item1 = array[start];
            int item2 = array[end];
            int res = item1 + item2;
            if (res == s) {
                return item1 + "-" + item2;
            } else if (res < s) {
                start++;
            } else if (res > s) {
                end--;
            }
        }
        return "null-null";
    }

    //自己实现
    static String findTowNum01(int[] array, int s){
        if (array == null || array.length == 0 || s < 0){
            return "null-null";
        }
        String result = null;
        for(int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++) {
                int i1 = array[i];
                int i2 = array[j];
                if (i1 + i2 == s) {
                    if (result != null) {
                        int p1 = Integer.parseInt(result.split("-")[0]);
                        int p2 = Integer.parseInt(result.split("-")[1]);
                        if (i1*i2 < p1*p2) {
                            result = i1 + "-" + i2;
                        }
                    } else {
                        result = i1 + "-" + i2;
                    }
                }
            }
        }
        return result;
    }


}
