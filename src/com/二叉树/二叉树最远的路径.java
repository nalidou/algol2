package com.二叉树;

import com.util.BiTreeUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉树最远的路径 {

    public static void main(String[] args) {

    }

    static List<BiTreeUtil.BiTreeNode> getLongRoad (BiTreeUtil.BiTreeNode node) {
        List<BiTreeUtil.BiTreeNode> list = new ArrayList<>();

        //return find(node, Integer.parseInt(node.v), list);
        return null;
    }

    static Map<Integer, List<BiTreeUtil.BiTreeNode>> find (BiTreeUtil.BiTreeNode node, int sum,
                                                 List<BiTreeUtil.BiTreeNode> list) {
        if (node == null) {
            Map<Integer, List<BiTreeUtil.BiTreeNode>> map = new HashMap<>();
            map.put(sum,list);
            return map;
        }
        List<BiTreeUtil.BiTreeNode> nlist = new ArrayList<>(list);
        nlist.add(node);
        sum = sum + Integer.parseInt(node.v);
        Map<Integer, List<BiTreeUtil.BiTreeNode>> lmap = find(node.l, sum, list);
        Map<Integer, List<BiTreeUtil.BiTreeNode>> rmap = find(node.r, sum, list);
        if (lmap.keySet().iterator().next() > rmap.keySet().iterator().next()) {
            return lmap;
        } else {
            return rmap;
        }

    }

}
