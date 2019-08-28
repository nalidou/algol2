package com.others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 来源：剑指offer 64
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。
 https://www.cnblogs.com/wxisme/p/5931906.html
 */
public class 滑动窗口的最大值64 {

    public static void main(String[] args) {

        int [] array = new int[]{2,3,4,2,6,2,5,1};
        System.out.println(solution(array, 3));
        for (int a:solution(array,3)) {
            System.out.print(array[a] + " ");
        }
    }

    private static List<Integer> solution(int [] array, int num) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList();

        for (int i=0;i<array.length;i++) {
            int item = array[i];
            while (!queue.isEmpty() && item > array[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);//存的是下标

            if (i - queue.getFirst() >= num) {
                queue.removeFirst();
            }

            if (i >= num-1) {
                list.add(queue.getFirst());
            }
        }

        return list;
    }


}
