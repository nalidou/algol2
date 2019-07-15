package com.linkedList;


import com.util.LinkedListUtil;

/**
 * 来源：剑指offer 25  未实现
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class 复杂链表的复制 {

    public static void main(String[] args) {
        String [] values = new String[] {"A", "B", "C", "D", "E"};
        String [] relations = new String[] {"C", "E", "C", "D", "E"};
        LinkedListUtil.DLNode head = LinkedListUtil.createDLNodeList(values);

        int r = 0;
        LinkedListUtil.DLNode node = head.next;
        LinkedListUtil.DLNode p = head.next;
        while (node != null) {
            while (!relations[r].equals(p.v)){
                p=p.next;
                break;
            }
            node.pre = p;
            node = node.next;
            r++;
            p = head.next;
        }

        LinkedListUtil.forEachDLNode(head);

    }

    static LinkedListUtil.DLNode copy(LinkedListUtil.DLNode head){
        return null;
    }
}
