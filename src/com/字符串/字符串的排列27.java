package com.字符串;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/***
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class 字符串的排列27 {

    public static void main(String[] args) {
        String str = "abcd";
        List<String> list = getList(str);
        Collections.sort(list);
        System.out.println(list);

    }

    static List<String> getList(String str) {
        List<String> list = new ArrayList<>();
        solu(str.toCharArray(), 0, list);
        return list;
    }

    static void solu(char[] chars, int begin, List<String> list){
        if (begin == chars.length) {
            list.add(String.valueOf(chars));
            return;
        }
        for (int i=begin; i<chars.length; i++) {
            if (i != begin && chars[i] == chars[begin]) {
                continue;
            }
            swap(chars, begin, i);
            solu(chars, begin+1, list);
        }

    }
    static void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}
