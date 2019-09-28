package com.笔试.新东方;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String line = in.nextLine();
        String s = "[[1,2,3],2,3,4][3,4,5]";
        System.out.println(getList(s));
    }

    static String getTree(String line) {
       List<List<String>> list = getList(line);

       for (List<String> item : list) {
           if (item.get(1).equals("0")) {

           }
       }
       return "";
    }

    //把字符串封装成数组,解决了缺失问题
    static List<List<String>> getList(String str) {
        List<List<String>> list = new ArrayList<>();
        int n = 0;
        List<String> item = new ArrayList<>();
        for (int i=0;i<str.length();i++) {
            if (n == 3) {
                list.add(item);
                item = new ArrayList<>();
                n = 0;
            }
            if (isNum(str.charAt(i))) {
                n++;
                item.add(String.valueOf(str.charAt(i)));
            }
        }
        return list;
    }

    //检查当前字符是否数字
    static boolean isNum(char c) {
        if (c == '[' || c == ']' || c == ',') {
            return false;
        }
        return true;
    }


}
