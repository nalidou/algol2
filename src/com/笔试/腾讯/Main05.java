package com.笔试.腾讯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        String line3 = in.nextLine();
        String[] a = line2.split(" ");
        String[] b = line3.split(" ");
        int [] array1 = new int[Integer.parseInt(line1)];
        int [] array2 = new int[Integer.parseInt(line1)];
        for (int i=0;i<Integer.parseInt(line1);i++) {
            array1[i] = Integer.parseInt(a[i]);
            array2[i] = Integer.parseInt(b[i]);
        }

        System.out.println(get(array1, array2));

    }

    static int get(int[] array1, int[] array2) {
        //List<Integer> list = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        for (int i=0;i<array1.length;i++) {
            for (int j=0;j<array2.length;j++) {
                list.add(array1[i] + array2[j]);
            }
        }

        int n = list.get(0);
        for (int k=1;k<list.size();k++) {
            n = n ^ list.get(k);
        }

        return n;
    }
}
