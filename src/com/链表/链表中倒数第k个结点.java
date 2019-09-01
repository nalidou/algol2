package com.链表;

import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 14
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class 链表中倒数第k个结点 {

    public static void main(String[] args) {
        LinkedListUtil.LNode head = LinkedListUtil.createLNodeList(new int[]{1,2,3,4,5,6,7,8,9});
        getLastK(head.next, 4); // 链表中倒数第k个结点
    }

    /**
     * 链表中倒数第k个结点
     */
    static int kk = 0;
    static void getLastK(LinkedListUtil.LNode node, int k){
        if (node == null) { return;}
        getLastK(node.next, k);
        kk++;
        if (kk == k) {
            System.out.println(node.v);
        }
    }
}
