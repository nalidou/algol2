package com.字符串;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置。
 */
public class 第一个只出现一次的字符34 {
    public static void main(String[] args) {

        String str = "wsdwsdawedscvbnm";
        System.out.println(str.charAt(getFirstOne(str)));

    }

    static int getFirstOne(String string){
        Map<String, Integer> map = new HashMap();
        for (int i=0;i<string.length();i++) {
            String c = String.valueOf(string.charAt(i));
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i=0;i<string.length();i++) {
            String c = String.valueOf(string.charAt(i));
            if (map.get(c) == 1){
                return i;
            }
        }

        return -1;

    }
}
