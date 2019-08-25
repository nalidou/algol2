package com.biTree;

/**
 * 来源：剑指offer 23
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes，否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {


    }

    private static boolean bst(int[] array, int begin, int end) {
        if (array.length == 0 || begin > end) {
            return false;
        }

        int root = array[end];
        //寻找左子树
        int i = begin;
        for (; i<end; i++) {
            if (array[i] > root) {
                break;
            }
        }
        //验证右子树
        for (int j=i; j<end; j++) {
            if (array[j] < root) {
                return false;
            }
        }
        boolean left = true;
        if (i > begin){
            left = bst(array, begin, i-1);
        }

        boolean right = true;
        if (i < end-1) {
            right = bst(array, begin, end);
        }
        return left && right;
    }
}
