package com.二叉树;

import com.util.BiTreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * 来源：剑指offer 17
 * 输入两颗二叉树A，B，判断B是不是A的子结构。
 * （PS：我们约定空树不是任意一个树的子结构）。
 */
public class 树的子结构 {

    public static void main(String[] args) {

        String [] pre = new String[] {"1", "2", "4", "7", "3", "5", "6", "8"};
        String [] mid = new String[] {"4", "7", "2", "1", "5", "3", "8", "6"};
        List<String> preList = Arrays.asList(pre);
        List<String> midList = Arrays.asList(mid);
        BiTreeUtil.BiTreeNode root = BiTreeUtil.createTree(preList, midList);
        //BiTreeUtil.forEach(root, 2);

        String [] preChild = new String[] {"30", "5", "6", "8"};
        String [] midChild = new String[] {"5", "30", "8", "6"};
        List<String> preChildList = Arrays.asList(preChild);
        List<String> midChildList = Arrays.asList(midChild);
        BiTreeUtil.BiTreeNode child = BiTreeUtil.createTree(preChildList, midChildList);
        //BiTreeUtil.forEach(child, 2);
        System.out.println(isChildTree(root, child));
    }

    static boolean isChildTree(BiTreeUtil.BiTreeNode root, BiTreeUtil.BiTreeNode child) {
        if (root == null || child == null) {
            return false;
        }
        if (root.v.equals(child.v)) {
            return isEquals(root, child);
        } else {
            boolean isLChild = isChildTree(root.l, child);
            boolean isRChild = isChildTree(root.r, child);
            return (isLChild | isRChild);
        }
    }
    static boolean isEquals(BiTreeUtil.BiTreeNode root, BiTreeUtil.BiTreeNode child){
        if (child == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (!root.v.equals(child.v)) {
            return false;
        }
        return isEquals(root.l, child.l) && isEquals(root.r, child.r);
    }

}
