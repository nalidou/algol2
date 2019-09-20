package com.笔试.百度;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        for (int j=0;j<Integer.parseInt(line1);j++) {
            String line2 = in.nextLine();
            String[] pair = line2.split(" ");
            //int n = Integer.parseInt(pair[0]);
            int m = Integer.parseInt(pair[1]);
            String[] road = new String[m];
            for (int i = 0; i < m; i++) {
                road[i] = in.nextLine();
            }
            //System.out.println("m: " + m);
            for (String s : road) {
                //System.out.println(s);
            }
            // System.out.println("----");
            System.out.println(get(pair[0], road));
        }
    }

    static  String get(String end, String[] road) {
        String start = "1";
        Set<String> set = new HashSet<>();
        for (String str : road) {
            //System.out.println("1--" + str);
            String[] array = str.split(" ");
            if (array[0].equals(start)) {
                set.add(array[1]);
            }
        }
        //System.out.println(set);
        for (String str : road) {
            //System.out.println("2--" + str);
            String[] array = str.split(" ");
            if (array[1].equals(end)) {
                if (set.contains(array[0])){
                    return "POSSIBLE";
                }
            }
        }
        return "IMPOSSIBLE";
    }


}
