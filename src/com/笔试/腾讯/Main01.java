package com.笔试.腾讯;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] array = new String[n];
        for (int i=0;i<n;i++) {
            int k = Integer.parseInt(in.nextLine());
            String item = in.nextLine();
            array[i] = item;
        }

        get(array);
    }

    static void get(String[] array) {
        for (String s : array) {
            int n = 0;
            for(int i=0;i<s.length();i++) {
                char c = s.charAt(i);
                try {
                    Integer.parseInt(String.valueOf(c));
                } catch (Exception e){
                    System.out.println("NO");
                    break;
                }

                if (c == '8') {
                    System.out.println("--> " + i);
                    n=i;
                    break;
                }
            }
            System.out.println("-->>>>" + (s.length()-n));
            if (s.length()-n == 10) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

}
