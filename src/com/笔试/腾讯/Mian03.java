package com.笔试.腾讯;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Mian03 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] array = new String[n];
        for (int i=0;i<n;i++) {
            in.nextLine();
            String line = in.nextLine();
            array[i] = line;
        }
        List<String> res = get(array);
        for (String s : res) {
            System.out.println(s);
        }
    }

    static  List<String> get(String[] array) {
        List<String> result = new ArrayList<>();
        for (String s : array) {
            List<Integer> list = new ArrayList<>();
            String[] args = s.split(" ");
            for (String a : args) {
                list.add(Integer.parseInt(a));
            }
            Collections.sort(list);
            int n1=0,n2=0;
            for (int i=0;i<list.size()/2;i++) {
                if (i % 2 == 0) {
                    n1 = n1 + list.get(i)+list.get(list.size()-1-i);
                } else {
                    n2 = n2 + list.get(i)+list.get(list.size()-1-i);
                }
            }
            if (n1 >n2){
                //System.out.println(n2 + " " + n1);
                result.add(n2 + " " + n1);
            } else {
                //System.out.println(n1 + " " + n2);
                result.add(n1 + " " + n2);
            }
        }
        return result;
    }
}
