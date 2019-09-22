package com.笔试.腾讯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            String line = in.nextLine();
            int n1 = Integer.parseInt(line.split(" ")[0]);
            int n2 = Integer.parseInt(line.split(" ")[1]);

            for (int j=0;j<n1;j++) {
                list.add(n2);
            }
        }
        Collections.sort(list);
        System.out.println(get(list));

    }
    static int get(List<Integer> list) {
        int n=0;
        for (int i=0;i<list.size() / 2;i++) {
            int s = list.get(i);
            int e = list.get(list.size()-1-i);
            if (s+e > n) {
                n = s+e;
            }
        }
        return n;
    }


}
