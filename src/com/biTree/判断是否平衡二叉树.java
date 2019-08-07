package com.biTree;

import com.util.BiTreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 来源：剑指offer 39
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class 判断是否平衡二叉树 {

    public static void main(String[] args) {
//        String [] pre = new String[] {"1", "2", "4", "7", "3", "5", "6", "8"};
//        String [] mid = new String[] {"4", "7", "2", "1", "5", "3", "8", "6"};
//        List<String> preList = Arrays.asList(pre);
//        List<String> midList = Arrays.asList(mid);
//        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);

        String [] pre = new String[] {"1", "2", "4", "5", "3", "6", "7"};
        String [] mid = new String[] {"4", "2", "5", "1", "6", "3", "7"};
        List<String> preList = Arrays.asList(pre);
        List<String> midList = Arrays.asList(mid);
        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);
        System.out.println(isBalance(root));

    }

    static boolean isBalance(BiTreeUtil.BiTreeNode root){
        if(deep(root) == -1) {
            return false;
        }
        return true;
    }
    static int deep(BiTreeUtil.BiTreeNode root) {
        if (root == null) {
            return 0;
        }
        int ldeep = deep(root.l);
        int rdeep = deep(root.r);
        if (ldeep == -1 || rdeep == -1 || Math.abs(ldeep - rdeep) > 1) {
            return -1;
        }
        return Math.max(ldeep+1, rdeep+1);
    }



}
