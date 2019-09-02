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
        int[] arr1 = new int[]{1,2,3,4,5};
        int[] arr2 = new int[]{4,3,5,1,2};
        System.out.println(getResult(arr1, arr2));
    }

    static boolean getResult(int[] arr1, int[] arr2){
        Stack<Integer> stack = new Stack();
        int k = 0;
        for (int i=0; i<arr1.length; i++) {
            int item1 = arr1[i];
            stack.push(item1);
            for (; k<arr2.length; k++) {
                if (arr2[k] == stack.peek()) {
                    stack.pop();
                } else {
                    break;
                }
            }

        }
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
