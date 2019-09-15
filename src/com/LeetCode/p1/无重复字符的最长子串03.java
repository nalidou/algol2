package com.LeetCode.p1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 无重复字符的最长子串03 {

    public static void main(String[] args) {
        String s = "ababcabcdc";
        System.out.println(sub(s));
    }

    static String sub(String string) {
        Set<String> set = new HashSet<>();
        int sum = 0;
        int cur = 0;
        int start = 0;
        int index = 0;
        for (int i=start; i<string.length(); i++) {
            String c = String.valueOf(string.charAt(i));
            //System.out.println(c + " " + start + " " + cur + " " + sum);
            if (set.contains(c)) {
                if (cur > sum) {
                    sum = cur;
                    index = start;
                }
                start = start + 1;
                i = start - 1;
                set = new HashSet<>();
                cur = 0;
            } else {
                set.add(String.valueOf(c));
                ++cur;
            }
        }
        if (cur > sum) {
            sum = cur;
            index = start;
        }

        return string.substring(index, index+sum);
    }
}
