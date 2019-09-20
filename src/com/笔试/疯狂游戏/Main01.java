package com.笔试.疯狂游戏;

import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        //String[] s1 = new String[]{"aflower", "bflow", "flight"};
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println(findLong(line.split(" ")));
    }

    static String findLong(String[] array) {
        String item = "";
        int len = Integer.MAX_VALUE;
        for (String s : array) {
            if (s.length() < len) {
                len = s.length();
                item = s;
            }
        }

        for (int i=0;i<item.length();i++) {
            char c = item.charAt(i);

            for (int j=0;j<array.length;j++) {
                String str = array[j];
                if (c != str.charAt(i)) {
                    return item.substring(0, i);
                }
            }
        }

        return "";
    }
}
