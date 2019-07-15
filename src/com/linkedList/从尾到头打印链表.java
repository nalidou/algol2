package com.linkedList;

import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 03
 * 输入一个链表，返回一个反序的链表。
 */
public class 从尾到头打印链表 {

    public static void main(String[] args) {
        LinkedListUtil.LNode head = LinkedListUtil.createLNodeList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        //LinkedListUtil.forEachLNode(head); //遍历

        forEachReverse(head.next); // 从尾到头打印链表
    }

    /**
     * 从尾到头打印链表
     * @param node
     */
    static void forEachReverse(LinkedListUtil.LNode node){
        if (node == null) { return;}
        forEachReverse(node.next);
        System.out.print(node.v + " ");
    }
}
