package com.字符串;

/**
 * 来源：剑指offer 52
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配。
 */
public class 正则表达式匹配52 {
    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "a.aa";
        System.out.println(isMatcch(str1, 0, str2, 0));
    }

    static boolean isMatcch(String str1, int cur1, String str2, int cur2) {
        if (cur1 == str1.length() && cur2 == str2.length()) {
            return true;
        }
        if (cur1 != str1.length() && cur2 == str2.length()) {
            return false;
        }
        if (str1.charAt(cur1) == str2.charAt(cur2)
                || (str2.charAt(cur2) == '.'
                    && cur1 != str1.length())) {
            return isMatcch(str1, cur1+1, str2, cur2+1);
        }
        if (str2.charAt(cur2+1) == '*') {
            if (str1.charAt(cur1) == str2.charAt(cur2)
                    || (str2.charAt(cur2)=='.'
                    &&cur1 != str1.length())) {
                return isMatcch(str1, cur1+1, str2, cur2+2)
                        || isMatcch(str1, cur1+1, str2, cur2)
                        || isMatcch(str1, cur1, str2, cur2+2);
            }else {
                return isMatcch(str1, cur1, str2, cur2);
            }
        }
       return false;
    }
}
