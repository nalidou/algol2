package com.biTree;

import com.util.BiTreeUtil;

import java.util.*;

/**
 * 来源：剑指offer 22
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class 从上往下打印二叉树 {

    public static void main(String[] args) {

        String [] pre = new String[] {"1", "2", "4", "5", "3", "6", "7"};
        String [] mid = new String[] {"4", "2", "5", "1", "6", "3", "7"};
        List<String> preList = Arrays.asList(pre);
        List<String> midList = Arrays.asList(mid);
        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);
        //BiTreeUtil.forEach(root, 1);
        print(root);
    }

    static void print(BiTreeUtil.BiTreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BiTreeUtil.BiTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BiTreeUtil.BiTreeNode node = queue.removeFirst();
            System.out.print(node.v + " ");
            if (node.l != null) {
                queue.add(node.l);
            }
            if (node.r != null) {
                queue.add(node.r);
            }
        }
    }
}
