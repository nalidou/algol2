package com.链表;

import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 15
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class 反转链表 {

    public static void main(String[] args) {
        LinkedListUtil.LNode head = LinkedListUtil.createLNodeList(new int[]{1,2,3,4,5,6,7,8,9});

        //反转链表
        LinkedListUtil.LNode newHead = LinkedListUtil.generateNewLNode();
        getReverseList(head.next, newHead);
        LinkedListUtil.forEachLNode(newHead);

    }


    /**
     * 输入一个链表，反转链表后，输出链表的所有元素。
     * 思路：1->2->3->4->5
     * node代表当前节点，head代表反转后的头节点
     * 层层递归，找到最后一个node是5，把head.next = node，此时head->5，然后返回这个节点
     * 跳出第5层，回到第4层，此时node是4，nextNode是5，让5->4, 4->null,此时head->5->4->null，返回当前节点4
     * 跳出第4层，回到第3层，此时node是3，nextNode是4，让4->3, 3->null,此时head->5->4->3->null，返回当前节点3
     * 跳出第3层，回到第2层，此时node是2，nextNode是3，让3->2, 2->null,此时head->5->4->3->2->null，返回当前节点2
     * 跳出第2层，回到第1层，此时node是1，nextNode是2，让2->1, 1->null,此时head->5->4->3->1->null，返回当前节点1
     * 此时链表已经完全反转了过去，直接调用head就可以打印全部
     * @param node
     * @param head
     * @return
     */
    static LinkedListUtil.LNode getReverseList(LinkedListUtil.LNode node, LinkedListUtil.LNode head){
        if (node.next == null) {
            head.next = node;
            //System.out.println("找到最后一个节点：" + head.next.v);
            return node;
        }
        LinkedListUtil.LNode nextNode = getReverseList(node.next, head);
        nextNode.next = node;
        node.next = null;
        return node;
    }
}
