package com.笔试.网易;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] array = new int[n];
        for (int i=0;i<n;i++){
            array[i] = in.nextInt();
        }
        get(array);

    }

    static void get(int[] array) {
        for (int n : array) {
            if (n < 10) {
                System.out.println(n);
            } else {
                find(n);
            }
        }

    }

    static void find (int n) {
        int k=0;
        int m = n;
        while (m > 0){
            k++;
            m = m/10;
        }
        for (int i=1;i<10;i++) {
            for (int j=0;j<10;j++) {
                if (i + j >= n) {
                    System.out.println(i+""+j);
                    return;
                }
            }
        }


    }





}
