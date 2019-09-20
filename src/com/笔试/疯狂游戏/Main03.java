package com.笔试.疯狂游戏;

import java.util.Scanner;

public class Main03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line  = in.nextLine();
        System.out.println(get(line.split(" ")[0],line.split(" ")[1]));
    }

    static int get(String s1, String s2) {
        int n = 0;
        for (int i=0;i<s2.length();i++) {
            if (i<s1.length()) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    n++;
                }
            } else {
                n++;
            }

        }
        return n;
    }

}
