package com.链表;


import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 55
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class 链表中环的入口结点 {

    public static void main(String[] args) {
        LinkedListUtil.LNode head1 = LinkedListUtil.createLNodeList(new int [] {1,2,3,4,5});
        LinkedListUtil.LNode head2 = LinkedListUtil.createLNodeList(new int [] {6,7,8});
        head2.next.next.next.next = head2.next; // head2变成环
        //LinkedListUtil.forEachLNode(head2);
        LinkedListUtil.jiont(head1, head2.next); //head2接到head1后面,此时head1就是一个带环的链表
        //LinkedListUtil.forEachLNode(head1); //1,2,3,4,5,6,7,8,6,7,8,6,7,8....

        LinkedListUtil.LNode node = getNode(head1);
        System.out.println("得到链表中环的入口结点: " + node.v);

    }

    static LinkedListUtil.LNode getNode(LinkedListUtil.LNode head) {
        int loopLen = getLoopLen(head); // 3
        System.out.println("环的长度是：" + loopLen);
        LinkedListUtil.LNode node1 = head.next;
        LinkedListUtil.LNode node2 = head.next;
        //先让node2走loopLen步
        for (int i=0; i<loopLen; i++) {
            node2 = node2.next;
        }
        //之后两个指针同时走
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        //碰面时就是环的开始位置
        return node1;
    }

    //返回单链表环的长度
    static int getLoopLen(LinkedListUtil.LNode head){
        int len = 0;
        LinkedListUtil.LNode node1 = head.next;
        LinkedListUtil.LNode node2 = head.next.next;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        System.out.println("两指针相遇于：" + node1.v);
        node2 = node2.next;
        len ++;
        while (node1 != node2) {
            len ++;
            node2 = node2.next;
        }
        return len;
    }

}
