package com.biTree;

import com.util.BiTreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 来源：剑指offer 04
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class 重建二叉树 {

    public static void main(String[] args) {

        //BiTreeUtil.BiTreeNode root = new BiTreeUtil.BiTreeNode();
        //BiTreeUtil.createTree(root);
        //BiTreeUtil.forEach(root);

        String [] pre = new String[] {"1", "2", "4", "7", "3", "5", "6", "8"};
        String [] mid = new String[] {"4", "7", "2", "1", "5", "3", "8", "6"};

        List<String> preList = Arrays.asList(pre);
        List<String> midList = Arrays.asList(mid);
        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);
        BiTreeUtil.forEach(root);
    }

}
