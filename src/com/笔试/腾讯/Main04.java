package com.笔试.腾讯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int k = Integer.parseInt(line1.split(" ")[1]);
        String[] strs = line2.split(" ");
        List<Integer> array = new ArrayList<>();
        for (int i=0;i<strs.length;i++) {
            array.add(Integer.parseInt(strs[i]));
        }
        get(array, k);
    }

    static void get(List<Integer> list, int k) {
        Collections.sort(list);
        Object[] array = list.toArray();
        int t = 0;
        for (int i=0;i<k;i++) {
            for (int j=0;j<array.length;j++) {
                int item = Integer.parseInt(String.valueOf(array[j]));
                if (item > 0) {
                    System.out.println(item);
                    t = item;
                    for (int m=0;m<array.length;m++) {
                        array[m] = Integer.parseInt(String.valueOf(array[m])) - t;
                    }
                    break;
                }
                if (j == array.length-1) {
                    System.out.println(0);
                }
            }
        }
    }
}
