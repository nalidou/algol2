package com.util;

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

    public static void forEach(BiTreeNode T){
        if(T.v == null){//判断这个节点的数据是否为空
            return;
        }
        forEach(T.l);
        forEach(T.r);
        System.out.print(T.v);//后序遍历
    }

    public static class BiTreeNode{
        String v = null;
        BiTreeNode l = null;
        BiTreeNode r = null;
    }
}
