package com.biTree;


import com.util.BiTreeUtil;

/**
 * 来源：剑指offer 57
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 二叉树的下一个节点 {

    public static void main(String[] args) {


    }

    static BiTreeUtil.BiTreeNode getNextNode(BiTreeUtil.BiTreeNode node){
        if (node.r != null) {
            //右子树非空
            BiTreeUtil.BiTreeNode rNode = node.r;
            while (rNode.l != null) {
                rNode = rNode.l;
            }
            return rNode;
        } else if (node == node.p.l) {
            //右子树为空，它是父节点的左节点
            return node.p;
        } else {
            while (node.p != null && node == node.p.r) {
                node = node.p;
            }
            return node;
        }

    }
}
