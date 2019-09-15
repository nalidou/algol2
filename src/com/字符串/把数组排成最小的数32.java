package com.字符串;

import java.util.Arrays;
import java.util.Comparator;

/**
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class 把数组排成最小的数32 {

    public static void main(String[] args) {
        int[] array = new int[]{2,3,1,4,5,23,1,43};
        int[] array2 = new int[]{3,32,321};

        System.out.println(get(array));
    }

    static String get(int [] array) {
        String [] arrays = new String[array.length];
        for (int i=0;i<array.length;i++) {
            arrays[i] = String.valueOf(array[i]);
        }
        Arrays.sort(arrays, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //System.out.println(o1 + " - " +o2);
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String s : arrays) {
            sb.append(s);
        }
        return sb.toString();
    }
}
