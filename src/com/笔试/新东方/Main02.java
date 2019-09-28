package com.笔试.新东方;

public class Main02 {

    public static void main(String[] args) {


    }

    static boolean match(String str, String match) {
        int i=0;
        for (i=0;i<match.length() && i<str.length();i++) {
            char c1 = match.charAt(i);
            char c2 = str.charAt(i);
            if (c1 == c2) {
                continue;
            } else if(c1 == '?') {

            }


        }

        return true;
    }
}
