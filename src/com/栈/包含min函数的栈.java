package com.栈;

import java.util.Stack;

/**
 * 来源：剑指offer 20
 * 定义栈的数据结构，请在类型中实现一个能够得到栈最小元素的min函数。
 * 思路：使用两个stack，一个为数据栈，另一个为辅助栈。数据栈用于存储所有数据，辅助栈用于存储最小值。
 */
public class 包含min函数的栈 {

    public static void main(String[] args) {
//
//        Stack stack = new Stack();
//        StackUtil.pushAll(new int[]{1,2,3,4,5,6}, stack);
//        StackUtil.popAll(stack);
//        System.out.println(stack.get(0));
//        System.out.println(stack.get(stack.size()-1));

        push(3);
        push(3);
        push(4);
        push(5);
        push(2);
        push(1);
        push(1);
        pop();
        pop();
        pop();
        pop();

    }

    static Stack dataStack = new Stack();
    static Stack minStack = new Stack();
    static void push (int v) {
        dataStack.push(v);
        if (minStack.isEmpty()) {
            minStack.push(v);
        } else {
            int minTop = Integer.valueOf(String.valueOf(minStack.peek()));
            if (v <= minTop) {
                minStack.push(v);
            }
        }
        System.out.println("最小元素：" + minStack.peek());
    }

    static void pop() {
        int data = Integer.valueOf(String.valueOf(dataStack.pop()));
        int minTop = Integer.valueOf(String.valueOf(minStack.peek()));
        if (data == minTop) {
            minStack.pop();
        }
        System.out.println("出栈元素：" + data + ", 最小元素：" + minStack.peek());
    }
}
