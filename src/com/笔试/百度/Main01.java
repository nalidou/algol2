package com.笔试.百度;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] array = line.split(" ");
        try {
            int n = Integer.parseInt(array[0]);
            int m = Integer.parseInt(array[1]);
            int k = Integer.parseInt(array[2]);

            System.out.println(get(n,m,k));
        } catch (Exception e){
            System.out.println(0);
        }

    }

    static int get(int n, int m, int k) {
        int a=0, b=0;
        while (true) {
            if ((n-a)*(m-b)<=k) {
                break;
            } else {
                if (n>m) {
                    a++;
                } else {
                    b++;
                }

            }
        }
        return a + b;
    }


}
