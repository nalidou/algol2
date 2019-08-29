package com.others;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 来源：剑指offer 33
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class 丑数33 {

    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 5;
        array[5] = 5;
        array[6] = 6;
        array[7] = 7;
        array[8] = 4;

//        forEach(array);
//        sort(array, 9);
//        System.out.println();
//        forEach(array);

        Object[] arrayN = getN(10);
        forEach(arrayN);

    }

    //获取n个丑数
    static Object[] getN(int n){
        List<Integer> array = new ArrayList<>(n);
        Set<Integer> set = new TreeSet<Integer>();
        for (int i=1; i<n && i<7; i++) {
            set.add(i);
            array.add(i);
        }
        for (int i=1; i<n-3; i++) {
            int item = array.get(i);
            if (set.add(item*2)){
                array.add(item*2);
            }
            if (set.add(item*3)){
                array.add(item*3);
            }
            if (set.add(item*5)) {
                set.add(item*5);
            }
        }
        System.out.println(array);
        return set.toArray();
    }


    /**
     * 0 1 2 3 5 5 6 7 [4]
     * 对一个有序的数组，加上最后一个，重新排序
     * @param array
     * @param
     */
    static int sort(int[] array, int len) {
        int n = len-1;
        for (int i=len-2; i>=0; i--) {
            if (array[n] < array[i]) {
                swap(array, n, i);
                n = i;
            } else {
                break;
            }
        }
        return len;
    }

    static void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    static void forEach(Object[] array){
        for (Object i : array) {
            System.out.print(i + " ");
        }
    }




}
