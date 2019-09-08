package com.字符串;


/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格02 {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("hello world tom jerry");
        System.out.println(solu(stringBuffer));
    }

    static String solu(StringBuffer stringBuffer){
        int len  = stringBuffer.length();
        int blackSpaceNum = 0;
        for (int i=0; i<len; i++) {
            if (stringBuffer.charAt(i) == ' ') {
                ++blackSpaceNum;
            }
        }
        System.out.println("blackSpaceNum: " + blackSpaceNum);

        int p = len-1;
        int q = p + blackSpaceNum*3;
        for (; p>=0; --p) {
            if (stringBuffer.charAt(p) == ' '){
                stringBuffer.replace(q-3, q , "%20");
                q = q - 3;
                System.out.println(stringBuffer.toString());
            } else {
                stringBuffer.replace(q-1, q, String.valueOf(stringBuffer.charAt(p)));
                System.out.println(stringBuffer.toString());
            }
        }

        return stringBuffer.toString();

    }
}
