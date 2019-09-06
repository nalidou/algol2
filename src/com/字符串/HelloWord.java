package com.字符串;

/**
 *  有hell, well, hello, world等字符串组，现在问能否拼接成helloworld，代码实现。
 *
 *  看看动态规划
 */
public class HelloWord {

    public static void main(String[] args) {


    }

    static boolean getResult(String[] array, String string) {

        for (int i=0;i<array.length;i++) {
            String str = array[i];

        }

        return false;
    }

    static String se(String str, String string) {
        char [] strs = str.toCharArray();
        char [] strings = string.toCharArray();
        for (int i=0;i<strings.length;i++) {
            for(int j=0;j<strs.length;j++) {
                if (strs[j] == strings[i]) {

                }
            }
        }
        return "";
    }
}
