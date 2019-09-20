package com.笔试.搜狗;

import java.util.*;

public class Main01 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        Set<String> nset = new HashSet<>();
        List<String> mList = new ArrayList<>();
        for (int i=0;i<n;i++) {
            nset.add(in.nextLine());
        }
        for (int j=0;j<m;j++) {
            mList.add(in.nextLine());
        }
        int [] res = get(nset,mList);
        for (int i : res) {
            System.out.print(i + " " );
        }
    }

    static int[] get(Set<String> nset, List<String> mList) {
        int [] result = new int[mList.size()];
        for (int i=0; i<mList.size(); i++) {
            String item = mList.get(i);
            if (has(nset, item) ) {
                result[i] = 1;
            }
        }
        return result;
    }

    static boolean has (Set<String> set, String s) {
        if (set.contains(s)) {
            return true;
        }
        for (String str : set) {

            if (str.startsWith("*")) {
                String str1 =  str.substring(1, str.length());
                String s1 = s.substring(s.length()-str1.length(), s.length());
                //System.out.println("start: " + str1 + " " + s1 );
                if (str1.equals(s1)) {
                    return true;
                }
            }
            if (str.endsWith("*")) {
                String str2 = str.substring(0, str.length()-1);
                String s2 = s.substring(0, str2.length());
                //System.out.println("end: " + str2 + " " + s2);
                if (str2.equals(s2)) {
                    return true;
                }
            }
        }
        return false;
    }


}
