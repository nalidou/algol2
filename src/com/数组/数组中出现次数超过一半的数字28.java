package com.数组;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class 数组中出现次数超过一半的数字28 {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};

        //System.out.println(getNum(array));
        System.out.println(getNum2(array));


    }

    static int getNum2(int[] array){
        int num = array[0];
        int n = 1;
        for (int i=1;i<array.length;i++) {
            if (n == 0) {
                num = array[i];
                n = 1;
                continue;
            }
            if (num == array[i]) {
                n++;
            } else {
                n--;
            }
        }
        n = 0;
        for (int a : array) {
            if (a == num) {
              n++;
            }
        }
        return n > array.length>>1 ? num : 0;
    }
    static int getNum(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer n : array) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n)+1);
            } else {
                map.put(n, 1);
            }
        }
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            //System.out.println(integer + " " + map.get(integer));
            if (map.get(integer) > array.length/2) {
                return integer;
            }
        }

        return 0;

    }
}
