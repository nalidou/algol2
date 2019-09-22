package com.笔试.字节跳动;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        String[] array = new String[k];
        int [] marray = new int[k];
        for (int i=0;i<k;i++) {
            String nm = in.nextLine();
            array[i] = in.nextLine();
            marray[i] = Integer.parseInt(nm.split(" ")[1]);
        }
        get(array, marray);
    }

    static  void get(String[] list, int[] ms){
        for (int i=0;i<list.length;i++) {
            String[] arrays = list[i].split(" ");
            int m = ms[i];
            int [] array = new int[arrays.length];
            for (int k=0;k<array.length;k++) {
                array[k] = Integer.parseInt(arrays[k]);
            }
            int sum = 0;
            List<Integer> sumList = new ArrayList<>();
            for (int j=0;j<array.length;j++) {
                //System.out.println("-->" + sumList);
                sum = sum + array[j];
                sumList.add(array[j]);
                Collections.sort(sumList);
                if (sum>m) {
                    int index = 0;
                    int sum2 = sum;
                    for (int si=sumList.size()-1;si>=0;si--){
                        index++;
                        int item = sumList.get(si);
                        sum2 = sum2 - item;
                        if (m >= sum2) {
                            System.out.print(index + " ");
                            break;
                        }
                    }
                } else {
                    System.out.print(0 + " ");
                }
            }

            System.out.println();
        }
    }


}
