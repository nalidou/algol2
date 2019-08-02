package com.util;


import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 栈工具类
 */
public class StackUtil {

    public static void pushAll(int [] arr, Stack stack){
        for (int a : arr) {
            stack.push(a);
        }
    }

    public static void popAll(Stack stack) {
        Stack clone = (Stack) stack.clone();
        while(!clone.empty()) {
            System.out.print(clone.pop() + " ");
        }
        System.out.println();
    }


}
