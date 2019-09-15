package com.笔试.小米;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


/**
 * 2480 游戏，左移一位的结果
 *
 * 4
 0 0 2 4
 0 2 2 2
 0 4 2 2
 8 8 2 2

 2 4 0 0
 4 2 0 0
 4 4 0 0
 16 4 0 0
 */
public class Main02 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String[] input) {
        StringBuffer stringBuffer = new StringBuffer();

        for (String string : input) {
            String[] strings = string.split(" ");
            int[] ints = new int[strings.length];
            for (int i=0;i<strings.length;i++) {
                ints[i] = Integer.parseInt(strings[i]);
            }
            String res = toLeft(ints);
            System.out.println(res);
        }

        return "";
        //return stringBuffer.toString();
    }

    static String toLeft(int[] string){

        int len = string.length;
        for (int i=0; i<len; i++) {
            if (string[i] == 0) {
               continue;
            } else {
                try {
                    if (string[i] == string[i-1] && i != 0) {
                        string[i-1] = string[i]*2;
                        string[i] = 0;
                    }
                } catch (Exception e){
                    //System.out.println("--->> " + i);
                }

            }
        }
        for (int kk=0;kk<len;kk++) {
            for (int k = 0; k < len; k++) {
                if (string[k] == 0) {
                    int y = 0;
                    for (y = k + 1; y < len; y++) {
                        //System.out.println("y: " + y);
                        string[y - 1] = string[y];
                    }
                    string[y - 1] = 0;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int s : string) {
            sb.append(s + " ");
        }
        String rt = sb.toString();

        return rt.substring(0, rt.length()-1);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        //System.out.println(res);
    }
}
