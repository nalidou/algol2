package com.链表;

import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 36
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class 两个链表的第一个公共结点 {

    public static void main(String[] args) {

        LinkedListUtil.LNode end = LinkedListUtil.createLNodeList(new int[]{7,8,9});

        LinkedListUtil.LNode head1 = LinkedListUtil.createLNodeList(new int[]{1,2,3,4});
        LinkedListUtil.LNode head2 = LinkedListUtil.createLNodeList(new int[]{10,20});

        LinkedListUtil.jiont(head1, end.next);//拼接
        LinkedListUtil.jiont(head2, end.next);
        System.out.println(getPublicNode(head1, head2).v);

    }

    static LinkedListUtil.LNode getPublicNode(LinkedListUtil.LNode head1, LinkedListUtil.LNode head2){
        int node1Len = LinkedListUtil.getLength(head1);
        int node2Len = LinkedListUtil.getLength(head2);
        if (node1Len==0 || node2Len==0) {return null;}

        //让长的链表先走几步，走到和短的长度一样，两个再一起走
        if (node1Len > node2Len) {
            for (int i=0; i<node1Len-node2Len; i++) {
                head1 = head1.next;
            }
        } else if (node2Len > node1Len) {
            for (int i=0; i<node2Len-node1Len; i++) {
                head2 = head2.next;
            }
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }
}
