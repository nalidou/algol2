
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println(get(line.toCharArray()));
    }


    static String get(char[] string) {

        for (int i=0;i<string.length;i++) {
            char c = string[i];
            int flag = 0;
            int cint = Integer.parseInt(String.valueOf(c));
            for(int j=i+1;j<string.length;j++) {
                int cjint = Integer.parseInt(String.valueOf(string[j]));
                if (cint == cjint && flag == 1) {
                    string[i] = '0';
                    break;
                } else if (cint == cjint && flag == 0) {
                    string[j] = '0';
                }
                else if (cjint < cint) {
                    flag = 1;
                }

            }

        }
        String res = String.valueOf(string);
        return res.replace("0","");
    }

}
