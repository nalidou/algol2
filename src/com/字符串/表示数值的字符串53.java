package com.字符串;

/**
 * 来源：剑指offer 01
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class 表示数值的字符串53 {

    public static void main(String[] args) {

        String str = "-1E-16";
        String str1 = "3.1416";
        String str2 = "12e+4.3";
        //System.out.println(isNumeric(str));
        //System.out.println(isNumeric(str1));
        System.out.println(isNumeric(str2));
    }

    static boolean isNumeric(String string) {
        // 非法输入处理
        if(string == null || string.length() == 0){
            return false;
        }
        // 正负号判断
        int i = 0;
        if(string.charAt(i) == '+' || string.charAt(i) == '-'){
            ++i;
        }
        boolean numeric = true;
        i = scanDigits(string, i);

        if(string.length() != i){
            // 小数判断
            if(string.charAt(i) == '.'){
                ++i;
                i = scanDigits(string, i);
                if(string.charAt(i) == 'e' || string.charAt(i) == 'E'){
                    String res = isExponential(string, i);
                    if (res.split(":")[0].equals("true")){
                        numeric = true;
                    } else {
                        numeric = false;
                    }
                    i = Integer.parseInt(res.split(":")[1]);
                }
            }
            // 整数判断
            else if(string.charAt(i) == 'e' || string.charAt(i) == 'E'){
                String res = isExponential(string, i);

                if (res.split(":")[0].equals("true")){
                    numeric = true;
                } else {
                    numeric = false;
                }
                i = Integer.parseInt(res.split(":")[1]);

            }
            else{
                numeric = false;
            }
        }
        return numeric && string.length() == i;
    }



    // 扫描数字，对于合法数字，直接跳过
    static int scanDigits(String string, int i){
        while (i < string.length()
                && string.charAt(i) >= '0'
                && string.charAt(i) <= '9') {
            i++;
        }
        return i;
    }
    // 用来潘达un科学计数法表示的数值的结尾部分是否合法
    static String isExponential(String string, int i){
        ++i;
        if(string.charAt(i) == '+' || string.charAt(i) == '-'){
            ++i;
        }

        if(i == string.length()){
            return false + ":" + i;
        }
        i = scanDigits(string, i);

        // 判断是否结尾，如果没有结尾，说明还有其他非法字符串
        return (string.length() == i) + ":" + i;
    }


}
