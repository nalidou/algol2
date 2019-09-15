package com.数组;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 两数相加_LC_02 {

    public static void main(String[] args) {

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(5L);
        Set<Long> set = new HashSet<>(list);
        for (Long id : set) {
            System.out.println(id);
        }


    }


}
