package com.util;

/**
 * 链表工具类
 * 提供单链表、双链表常用操作
 */
public class LinkedListUtil {

    public static LNode generateNewLNode(){
        return new LNode();
    }

    public static DLNode generateNewDLNode(){
        return new DLNode();
    }

    /**
     * 创建单链表，返回head节点，其中head节点的v是null
     * @param arr
     * @return head
     */
    public static LNode createLNodeList(String arr[]){
        LNode head = generateNewLNode();
        LNode index = head;
        for (int i=0; i<arr.length; i++) {
            index.next = new LNode(arr[i]);
            index = index.next;
        }
        return head;
    }

    /**
     * 创建双链表，返回head节点，其中head节点的v是null
     * @param arr
     * @return head
     */
    public static DLNode createDLNodeList(String arr[]){
        DLNode head = generateNewDLNode();
        DLNode index = head;
        for (int i=0; i<arr.length; i++) {
            index.next = new DLNode(arr[i]);
            index = index.next;
        }
        return head;
    }

    public static LNode createLNodeList(int arr[]){
        LNode head = generateNewLNode();
        LNode index = head;
        for (int i=0; i<arr.length; i++) {
            index.next = new LNode(arr[i]);
            index = index.next;
        }
        return head;
    }

    /**
     * 遍历单链表
     * @param head
     */
    public static void forEachLNode(LNode head){
        LNode node = head;
        while (node.next != null) {
            System.out.print(node.next.v + " ");
            node.next = node.next.next;
        }
        System.out.println();
    }

    /**
     * 遍历双链表
     * @param head
     */
    public static void forEachDLNode(DLNode head){
        DLNode node = head.next;
        while (node != null) {
            System.out.print("("
                    //+node.pre==null?"null":node.pre.v
                    //+ ","
                    +node.v
                   // +","
                   // +node.next==null?"null":node.next.v
                    +") ");
            node = node.next;
        }
        System.out.println();
    }

    public static int getLength(LNode head){
        int len = 0;
        LNode node = head.next;
        while(node != null) {
            node = node.next;
            len++;
        }
        return len;
    }

    //单链表结构
    public static class LNode {
        public Object v = null;
        public LNode next = null;
        public LNode(){}
        public LNode(Object v){this.v = v;}
        public LNode(Object v, LNode next){this.v = v; this.next = next;}
    }

    //双链表结构
    public static class DLNode{
        public DLNode pre = null;
        public DLNode next = null;
        public Object v = null;
        public DLNode(){}
        public DLNode(Object v){this.v = v;}
        public DLNode(Object v, DLNode next){this.v=v;this.next = next;}
        public DLNode(Object v, DLNode pre, DLNode next){this.v=v;this.next = next;this.pre = pre;}
    }
}
