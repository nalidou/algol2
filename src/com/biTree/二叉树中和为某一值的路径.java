package com.biTree;

import com.util.BiTreeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 来源：剑指offer 24
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        String [] pre = new String[] {"1", "2", "4", "7", "3", "5", "6", "8"};
        String [] mid = new String[] {"4", "7", "2", "1", "5", "3", "8", "6"};

        List<String> preList = Arrays.asList(pre);
        List<String> midList = Arrays.asList(mid);
        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);
        //BiTreeUtil.forEach(root, 1);
        Stack stack = new Stack();
        road(root, 18, stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static boolean road(BiTreeUtil.BiTreeNode root, int sum, Stack stack) {
        if (root == null) {
            return false;
        }
        int sub = sum - Integer.valueOf(root.v);
        if (sub == 0) {
            stack.push(root.v);
            return true;
        } else if (sub > 0) {
            boolean lroad = road(root.l, sub, stack);
            boolean rroad = road(root.r, sub, stack);
            if (lroad || rroad) {
                stack.push(root.v);
                return true;
            }
        }
        return false;
    }

}
