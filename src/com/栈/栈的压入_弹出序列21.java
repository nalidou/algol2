package com.栈;


import java.util.Stack;

/**
 * 剑指offer 21
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 */
public class 栈的压入_弹出序列21 {

    public static void main(String[] args) {

    }

    static boolean getResult(int[] arr1, int[] arr2){
        Stack<Integer> stack = new Stack();
        int arr1Index = 0;
        stack.push(arr1[arr1Index]);
        for (int i=0; i<arr2.length; i++) {
            int item2 = arr2[i];
            int item1 = arr1[arr1Index];
            if (item1 != item2) {
                stack.push(item1);
            }

        }
        return false;
    }
}
