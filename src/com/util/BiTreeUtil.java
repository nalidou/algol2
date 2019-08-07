package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 二叉树工具类
 */
public class BiTreeUtil {

    public static void createTree(BiTreeNode T){
        String str = new Scanner(System.in).next();
        if("#".equals(str)){
            //如果是'#'，则不做任何处理，也就是说这个节点的数据、左孩子、右孩子都是null
            //但这个节点不是null，这里需要注意
        }else{
            T.v = str;//给节点赋值
            T.l = new BiTreeNode();
            T.r = new BiTreeNode();
            createTree(T.l);
            createTree(T.r);
        }
    }

    //根据前序和中序构建
    public static BiTreeNode createTree(List<String> pre, List<String> mid){
        if (pre.size() == 0) {
            return null;
        }
        BiTreeUtil.BiTreeNode rootNode = new BiTreeUtil.BiTreeNode(pre.get(0));
        int rootIndex=0;
        for (int i=0; i<mid.size(); i++) {
            if (pre.get(0).equals(mid.get(i))) {
                rootIndex = i;
                break;
            }
        }
        List<String> preLeft = new ArrayList<>();
        List<String> preRight = new ArrayList<>();
        List<String> midLeft = new ArrayList<>();
        List<String> minRight = new ArrayList<>();
        for (int j=0; j<rootIndex; j++) {
            preLeft.add(pre.get(j+1));
            midLeft.add(mid.get(j));
        }
        for (int k=rootIndex+1; k<mid.size(); k++) {
            preRight.add(pre.get(k));
            minRight.add(mid.get(k));
        }
        rootNode.l = createTree(preLeft, midLeft);
        rootNode.r = createTree(preRight, minRight);
        return rootNode;
    }

    public static void forEach(BiTreeNode T, int type){
        if(T==null || T.v == null){//判断这个节点的数据是否为空
            return;
        }
        if (type == 1) {
            System.out.print(T.v + " ");
            forEach(T.l, type);
            forEach(T.r, type);
        }

        if (type == 2) {
            forEach(T.l, type);
            System.out.print(T.v + " ");
            forEach(T.r, type);
        }

        if (type == 3) {
            forEach(T.l, type);
            System.out.print(T.v + " ");
            forEach(T.r, type);
        }
    }

    public static class BiTreeNode{
        public String v = null;
        public BiTreeNode l = null;
        public BiTreeNode r = null;
        public BiTreeNode(String v) {
            this.v = v;
        }
        public BiTreeNode(){}
    }
}
