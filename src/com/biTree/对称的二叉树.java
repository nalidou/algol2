package com.biTree;

import com.util.BiTreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 来源：剑指offer 58
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class 对称的二叉树 {

    public static void main(String[] args) {

        String [] pre = new String[] {"8", "6", "5", "7", "6", "7", "5"};
        String [] mid = new String[] {"5", "6", "7", "8", "7", "6", "5"};
        List<String> preList = Arrays.asList(pre);
        List<String> midList = Arrays.asList(mid);
        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);
        boolean result = sym(root);
        System.out.println(result);
    }

    static boolean sym(BiTreeUtil.BiTreeNode root) {
        List<String> preList = new ArrayList<>();
        List<String> symList = new ArrayList<>();
        preForEach(root, preList);
        lastForEach(root, symList);
        System.out.println(preList);
        System.out.println(symList);

        if (preList.size() == symList.size()) {
            for (int i=0; i<preList.size(); i++) {
                if (!preList.get(i).equals(symList.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    //前序遍历
    static void preForEach(BiTreeUtil.BiTreeNode root, List<String> preList) {
        if (root == null) {
            preList.add("null");
            return;
        }
        preList.add(root.v);
        preForEach(root.l, preList);
        preForEach(root.r, preList);
    }

    //前序对称遍历
    static void lastForEach(BiTreeUtil.BiTreeNode root, List<String> symList) {
        if (root == null) {
            symList.add("null");
            return;
        }
        symList.add(root.v);
        lastForEach(root.r, symList);
        lastForEach(root.l, symList);
    }
}
