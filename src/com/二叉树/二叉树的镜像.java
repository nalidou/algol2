package com.二叉树;

import com.util.BiTreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 来源：剑指offer 18
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class 二叉树的镜像 {

    public static void main(String[] args) {
        String [] pre = new String[] {"1", "2", "4", "5", "3", "6", "7"};
        String [] mid = new String[] {"4", "2", "5", "1", "6", "3", "7"};
        List<String> preList = Arrays.asList(pre);
        List<String> midList = Arrays.asList(mid);
        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);
        //BiTreeUtil.forEach(root, 2);
        image(root);
        BiTreeUtil.forEach(root, 1);
    }

    public static void image(BiTreeUtil.BiTreeNode root) {
        if (root != null) {
            BiTreeUtil.BiTreeNode tmp = root.l;
            root.l = root.r;
            root.r = tmp;
            image(root.l);
            image(root.r);
        }
    }
}
