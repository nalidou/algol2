package com.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 来源：剑指offer 54
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */

public class 字符流中第一个不重复的字符54 {

    public static void main(String[] args) {
        String str = "google";
        char[] chars = str.toCharArray();
        Map<String, Integer> map = new HashMap();
        for (char c : chars) {
            String cc = String.valueOf(c);
            if (map.containsKey(cc)){
                map.put(cc, map.get(cc) + 1);
            } else {
                map.put(cc, 1);
            }
        }
        for (char c : chars) {
            String cc = String.valueOf(c);
            if (map.get(cc) == 1) {
                System.out.println(c);
            }
        }


    }


}
