package algorithm_basic_accumulation.exam.wanmeishijie;

import java.util.*;

/**
 * Created by HYH on 2017/3/29.
 *
 * 爸爸去哪里
 * 这个问题的输入有点问题，不是很好解
 * http://discuss.acmcoder.com/topic/58dbb16c5858322920bdc9c0
 */
public class one {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String priceStr = sc.nextLine();
            String valueStr = sc.nextLine();
            int value = Integer.valueOf(valueStr);

            System.out.println(convert(convertStr(priceStr), value));
        }
    }

    private static int convert(int[] priceArr, int value) {
        Arrays.sort(priceArr);
        int num = 0;

        for (int i = priceArr.length - 1; i >= 0; i--) {
            if (value == 0) {
                if (num == 0) {
                    return -1;
                }
                return num;
            }
            num += value / priceArr[i];
            value %= priceArr[i];
        }
        return -1;
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
