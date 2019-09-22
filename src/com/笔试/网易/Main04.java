package com.笔试.网易;


import java.util.Scanner;

public class Main04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String[] array = in.nextLine().split(" ");
        int [] array1 = new int[array.length];
        for (int i=0;i<array.length;i++) {
            array1[i] = Integer.parseInt(array[i]);
        }
        System.out.println(get(array1));
    }

    static int get(int [] array) {
        int sum = 0;
        for (int i=0;i<array.length;i++) {
            for (int j=i+1;j<array.length;j++) {
                if (array[i] > array[j]) {
                    sum = sum + (j-i);
                }
            }
        }
        return sum;
    }


}
