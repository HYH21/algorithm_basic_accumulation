package algorithm_basic_accumulation.exam.wanmeishijie;

import java.util.Scanner;

/**
 * Created by HYH on 2017/3/29.
 *
 * 爸爸去哪儿
 */
public class oneDP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String priceStr = sc.nextLine();
            String valueStr = sc.nextLine();
            int value = Integer.valueOf(valueStr);
            int min = min(value, convertStr(priceStr));
            if (min > Integer.MAX_VALUE - value) {
                System.out.println(-1);
            } else {
                System.out.println(min);
            }
        }
    }


    public static int min(int value, int c[]) {
        int assist[] = new int[value + 1];
        for (int x = 1; x < value + 1; x++) {
            if (x >= c[0]) {
                assist[x] = assist[x - c[0]] + 1;
            } else {
                assist[x] = Integer.MAX_VALUE - value;
            }
            for (int i = 1; i < c.length; i++) {
                if (x >= c[i] && (assist[x] > assist[x - c[i]] + 1)) {
                    assist[x] = assist[x - c[i]] + 1;
                }
            }
        }
        return assist[value];
    }

    private static int[] convertStr(String priceStr) {
        String[] strings = priceStr.split(",");
        int[] result = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = Integer.valueOf(strings[i]);
        }
        return result;
    }
}
