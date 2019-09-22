package com.笔试.字节跳动;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String line = in.nextLine();
        get(line);
    }

    static void get(String string) {

        for (int i=0;i<string.length();i++) {
            char c = string.charAt(i);
            if (c == 'O') {
                System.out.print(0 + " ");
            } else {
                int n = 0;
                boolean isPrint = true;
                for (int j=i-1;j>=0;j--) {
                    if (string.charAt(j) == 'O') {
                        //System.out.println("j: " + j);
                        n = i-j;
                        break;
                    }
                }
                for (int k=i+1;k<string.length();k++) {
                    if (string.charAt(k) == 'O') {
                        //System.out.println("k: " + k);
                        if (n < (k-i) && n !=0) {
                            System.out.print(n + " ");
                        } else {
                            System.out.print((k-i) + " ");
                        }
                        isPrint = false;
                        break;
                    }
                }
                if (isPrint) {
                    System.out.print(n + " ");
                }
            }
        }
    }

}
