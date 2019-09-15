package com.LeetCode.p1;

public class 最长回文子串05 {
    public static void main(String[] args) {
        String s = "asabcba";
        String s1 = "asabcccba";
        System.out.println(longestPalindrome(s1));

    }

    public static String longestPalindrome(String s) {
        if (s == null ||  s.equals("")) {
            return "";
        }
        int start=0, end=0;
        for (int i=0; i<s.length()-1; i++) {
            int[] item = get(s, i);
            if ((item[1] - item[0]) > (end - start)) {
                start = item[0];
                end = item[1];
            }
        }
        return s.substring(start, end+1);
    }

    static int[] get(String s, int i) {
        int[] res = new int[2];
        int[] pq = isSer(s, i);
        int p = pq[0], q = pq[1];
        while (p >=0 && q<=s.length()-1) {
            if (s.charAt(q) == s.charAt(p)) {
                res[0] = p;
                res[1] = q;
                p = p - 1;
                q = q + 1;
            } else {
                break;
            }
        }
        return res;
    }

    //字符串是否连续
    static int[] isSer(String s, int i) {
        int start = i;
        int end = i;
        char c = s.charAt(i);
        for (i=i+1; i<s.length(); i++) {
            if (s.charAt(i) == c) {
                end = i;
            } else {
                break;
            }
        }
        //System.out.println(start + " - " +end);
        return new int[] {start, end};
    }
}
