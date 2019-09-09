package com.笔试.欢聚时代;

import java.util.Scanner;

/**
 *
 */
public class Main01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String str = line.split(" ")[0];
        int n = Integer.parseInt(line.split(" ")[1]);
        System.out.println(get(str, n));

    }

    static String get(String str, int n) {
        String[] values = str.split("->");
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<values.length-n;i++) {
            sb.append(values[i]);
            sb.append("->");
        }
        for (n = values.length-n+1;n<values.length;n++) {
            sb.append(values[n]);
            sb.append("->");
        }

        return sb.substring(0, sb.length()-2);
    }
}
