package com.linkedList;

import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 36
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共结点 {

    public static void main(String[] args) {

        LinkedListUtil.LNode head1 = LinkedListUtil.createLNodeList(new int[]{1,2,3,4,5,6});
        LinkedListUtil.LNode head2 = LinkedListUtil.createLNodeList(new int[]{1,2,3,4,5,6,7,8,9});
        getPublicNode(head1, head2);
        LinkedListUtil.forEachLNode(head1);
    }

    static LinkedListUtil.LNode getPublicNode(LinkedListUtil.LNode head1, LinkedListUtil.LNode head2){
        int node1Len = LinkedListUtil.getLength(head1);
        int node2Len = LinkedListUtil.getLength(head2);
        System.out.println(node1Len);
        System.out.println(node2Len);
        return null;
    }
}
