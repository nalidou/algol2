package com.LeetCode.p1;

public class 两数相加02 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(1);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(9);

        ListNode p = addTwoNumbers(l1,l2);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
      public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode head = new ListNode(0);
          ListNode q = head;
          ListNode p1 = l1;
          ListNode p2 = l2;
          int flag = 0;
          while (p1 != null && p2 != null) {
              int sum = p1.val + p2.val;

              if (sum >= 10) {
                int sub = sum - 10 +  flag;
                if (sub >= 10) {
                    sub = sub - 10;
                    flag = 2;
                } else {
                    flag =1;
                }
                ListNode node = new ListNode(sub);
                q.next = node;
                q = q.next;
              } else {
                  sum = sum + flag;
                  if (sum >= 10) {
                      sum = sum - 10;
                      flag = 1;
                  } else {
                      flag = 0;
                  }
                  ListNode node = new ListNode(sum);
                  q.next = node;
                  q = q.next;
              }
              p1 = p1.next;
              p2 = p2.next;
          }
          ListNode lnode = p1 == null ? p2 : p1;
          while (lnode != null) {
              int sum = lnode.val + flag;
              if (sum >= 10) {
                  sum = sum - 10;
                  flag = 1;
              } else {
                  flag = 0;
              }
              q.next = new ListNode(sum);
              q = q.next;
              lnode = lnode.next;
          }
          if (flag != 0) {
              q.next = new ListNode(flag);
          }
          return head.next;
      }


}
