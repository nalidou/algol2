package com.笔试.欢聚时代;

import java.util.Scanner;

public class Main03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        int [] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = Integer.parseInt(in.nextLine());
        }
        System.out.println(get(array, m));
    }


    static String get(int [] array, int m) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (int i=0;i<m;i++){
            sb1.append(array[i] + " ");
        }
        for (int j=m;j<array.length;j++) {
            sb2.append(array[j] + " ");
        }

        return sb2.toString()+sb1.toString();
    }

}
