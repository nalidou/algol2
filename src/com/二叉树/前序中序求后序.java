package com.二叉树;

import com.util.BiTreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 前序中序求后序 {
    public static void main(String[] args) {

        int[] preArray = new int[]{1,2,4,5,3,6};
        int[] midArray = new int[]{4,2,5,1,6,3};

       // BiTreeUtil.createTree(Arrays.asList(preArray),new ArrayList<Integer>(midArray))l
        Node node = getAfterTree(preArray, midArray, 0, preArray.length-1, 0, midArray.length-1);

    }

    static Node getAfterTree(int[] preArray, int[] midArray, int preBegin, int preEnd, int midBegin, int midEnd) {
        if (preArray.length-1 < preBegin ) {
            return null;
        }
        if (midBegin == midEnd) {
            return new Node(preArray[preBegin]);
        }

        int value = preArray[preBegin];

        System.out.println(value);

        int pair = getindex(value, midArray);
        Node node = new Node(value);
        node.left = getAfterTree(preArray, midArray,
                (preBegin+1),
                (preBegin+(pair-midBegin)),
                (midBegin+1),
                (pair-1));
        node.right = getAfterTree(preArray, midArray,
                preBegin+(pair-midBegin)+1,
                preEnd,
                pair+1,
                midEnd);

        return node;

    }

    static int getindex(int value, int[] midArray) {

        for (int i=0;i<midArray.length;i++) {
            if (value == midArray[i]) {
                return i;
            }
        }
        return -1;
    }


    static class Node{
        public Node(int v) {
            this.v = v;
        }
        int v;
        Node left;
        Node right;
    }
}
