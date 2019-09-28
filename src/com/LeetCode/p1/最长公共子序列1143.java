package com.LeetCode.p1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 最长公共子序列1143 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        String t1 = "ezupkr";
        String t2 = "ubmrapg";
        System.out.println(longestCommonSubsequence(t1, t2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int t1 = 0;
        int sum = 0;
        for ( int i = 0;i<text2.length();i++) {
            char c = text2.charAt(i);
            int p = t1;
            int q = sum;
            for (;t1<text1.length();t1++) {
                if (text1.charAt(t1) == c) {
                    sum++;
                    break;
                }
            }
            if (t1 == text1.length() && q == sum) {
                t1 = p;
            }
            if (t1 == text1.length() && i != text2.length() && sum == 0) {
                t1 = 0;
            }
        }
        return sum;
    }
}
