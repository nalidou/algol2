package com.笔试.网易;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String [] array = new String[n];
        for (int i=0;i<n;i++) {
            array[i] = in.nextLine();
        }

        get(array);
    }

    static  void  get(String[] array) {
        for (String str : array) {
            String[] item = str.split(" ");
            int a = Integer.parseInt(item[0]);
            int b = Integer.parseInt(item[1]);
            int p = Integer.parseInt(item[2]);
            int q = Integer.parseInt(item[3]);
            int n1 = 0;
            int n2 = 0;
            int add = 0;
            int sub = 0;
            int flag = 1;
            while (b > a) {
                if (add == 2) {
                    n1 = n1 + 2;
                    p = p * q;
                    a = a + p;
                    add = 0;
                    continue;
                }
                add++;
                n1++;
                a = a+p;
            }
            System.out.println(n1);
        }
    }

}
