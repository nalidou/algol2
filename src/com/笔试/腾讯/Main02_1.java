package com.笔试.腾讯;

import java.util.*;

public class Main02_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<n;i++) {
            String line = in.nextLine();
            int n1 = Integer.parseInt(line.split(" ")[0]);
            int n2 = Integer.parseInt(line.split(" ")[1]);
            list.add(n2);
            map.put(n2, n1);
        }
        Collections.sort(list);
        System.out.println(get(list, map));

    }
    static int get(List<Integer> list, Map<Integer, Integer> map) {
        int n=0;
        for (int i=0;i<list.size() / 2;i++) {
            int s = list.get(i);
            int e = list.get(list.size()-1-i);
            //map.get(s);
            //map.get(e);
            map.remove(s);
            map.remove(e);
            if (s+e > n) {
                n = s+e;
            }
        }
        return n;
    }


}
