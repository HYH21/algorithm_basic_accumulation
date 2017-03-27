package algorithm_basic_accumulation.exam._360;

import java.util.Scanner;

/**
 * Created by HYH on 2017/3/25.
 *
 *
 */
public class two {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine())
        {
            String str = cin.nextLine();
            System.out.println(count(str));
        }
    }

    public static int count(String str) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            for(int j = i + 1; j < str.length(); j+=2) {
                if(isDoubleStr(str, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isDoubleStr(String str, int start, int end) {
        int[] arr = new int[27];
        for(int i = start ; i <= end; i++) {
            char c = str.charAt(i);
            arr[c - 'a']++;
        }
        for (int anArr : arr) {
            if (anArr % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
