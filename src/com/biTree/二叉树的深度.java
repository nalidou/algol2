package com.biTree;

import com.util.BiTreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 来源：剑指offer 38
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class 二叉树的深度 {

    public static void main(String[] args) {
        String [] pre = new String[] {"1", "2", "4", "7", "3", "5", "6", "8"};
        String [] mid = new String[] {"4", "7", "2", "1", "5", "3", "8", "6"};

        List<String> preList = Arrays.asList(pre);
        List<String> midList = Arrays.asList(mid);
        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);
        System.out.println(deep(root));
    }

    static int deep(BiTreeUtil.BiTreeNode root) {
        if (root == null) {
            return 0;
        }
        int ldeep = deep(root.l);
        int rdeep = deep(root.r);
        return Math.max(ldeep+1, rdeep+1);
    }
}
