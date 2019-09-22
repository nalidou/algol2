package com.笔试.网易;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] array = new String[n];
        for (int i=0;i<array.length;i++) {
            in.nextLine();
            array[i] = in.nextLine();
        }
        List<List<Integer>> list = new ArrayList<>();
        for (String str : array) {
            String[] strings = str.split(" ");
            List<Integer> l = new ArrayList<>();
            for (String s : strings) {
                l.add(Integer.parseInt(s));
            }
            list.add(l);
        }
        get(list);

    }

    static void get(List<List<Integer>> list) {
        for (List<Integer> array : list) {
            //Collections.sort(array);
            int start = 0;
            int all = 0;
            for (int i=start;i<array.size();i++) {
                int sum = 0;
                for (int j=start;j<i;j++) {
                    sum += array.get(j);
                }
                //System.out.println(array);
                //System.out.println("-> i=" + i + " sum=" + sum + " v=" + array.get(i));
                if (array.get(i) < sum) {
                    //System.out.println(i-start + " " +all);
                    if (i-start > all){
                        all = i-start;
                    }
                    i = ++start;
                }
            }
            System.out.println(all);
        }
    }


}
