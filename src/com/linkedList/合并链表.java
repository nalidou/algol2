package com.linkedList;

import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 16
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class 合并链表 {

    public static void main(String[] args) {
        LinkedListUtil.LNode head1 = LinkedListUtil.createLNodeList(new int[]{1,3,5,7,8});
        LinkedListUtil.LNode head2 = LinkedListUtil.createLNodeList(new int[]{0,2,4,5,8,9,9,10,13});

        LinkedListUtil.LNode result = merge(head1, head2);
        LinkedListUtil.forEachLNode(result);

    }

    /**
     * 思路：把链表2的数据逐个插入到链表1中，剩下的接后面
     * @param head1
     * @param head2
     * @return
     */
    static LinkedListUtil.LNode merge(LinkedListUtil.LNode head1, LinkedListUtil.LNode head2){
        if (head1.next == null || head2.next == null) {
            return null;
        }

        LinkedListUtil.LNode node1 = head1;

        //把链表2的数据逐个插入到链表1中
        while (node1.next != null && head2.next != null) {
            if ((int)node1.next.v > (int)head2.next.v) {
                LinkedListUtil.LNode tmp = head2.next; //取出这个节点
                head2.next = head2.next.next;//链表2后面的节点覆盖这个节点
                tmp.next = node1.next;//这个节点后面连上node1后面的节点
                node1.next = tmp;//node1后面连上这个节点
            } else {
                node1 = node1.next;
            }
        }

        //剩下的接后面
        while (head2.next != null) {
            node1.next = head2.next;
            node1 = node1.next;
            head2 = head2.next;
        }
        return head1;
    }
}
