package com.笔试.疯狂游戏;

import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String n = line.split(" ")[0];
        String[] array = line.split(" ")[1].split(",");
        System.out.println(find(n, array));
    }

    static String find(String n, String[] array) {
        int start=-1, end=-1;
        for (int i=0;i<array.length;i++) {
            if (array[i].equals(n)) {
                start = i;
                break;
            }
        }
        for (int j=array.length-1;j>=0;j--) {
            if (array[j].equals(n)) {
                end = j;
                break;
            }
        }
        return start + "," + end;

    }
}
