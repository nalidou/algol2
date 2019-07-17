package com.linkedList;

import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 56
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5。
 */
public class 删除链表中重复的结点 {

    public static void main(String[] args) {
        LinkedListUtil.LNode head = LinkedListUtil.createLNodeList(new int[] {1,2,3,3,4,4,4,5,5,6});
        dist(head);
        LinkedListUtil.forEachLNode(head);
    }

    static void dist (LinkedListUtil.LNode head) {
        LinkedListUtil.LNode node = head.next;
        while (node.next != null) {
            if (node.v == node.next.v) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
    }

}
