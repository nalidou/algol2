package com.笔试.途家;

import java.util.Scanner;

public class Main01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] vs = line.split(" ");
        int M = Integer.parseInt(vs[0]);
        int S = Integer.parseInt(vs[1]);
        int T = Integer.parseInt(vs[2]);
        System.out.println(getResult(M,S,T));
    }

    static String getResult(int M, int S, int T){
        if (M < 0 || S < 0 || T < 0) {
            return "";
        }
        int m1 = M / 10;//法术时间
        int m2 = M % 10;

        //法术距离
        int mL = m1 & 50;
        if (m1 >= T) {
            int minL = S / 50;
            int minLs = S % 50;
            if(minLs != 0) {
               minL++;
            }
            return "Yes " + minL;
        } else {
            int subL = S - mL;
            int subT = T - m1;
            if (subT * 13 >= subL) {
                int a = subL%13;
                int time = m1 + subL/13;
                if (a != 0){
                    time++;
                }
                return "Yes " +time;
            } else {
                int l = mL + subT*13;
                return "No "+l;
            }
        }

    }
}
