package algorithm_basic_accumulation.leetcode;

/**
 * Created by HYH on 2017/3/29.
 * <p>
 * Ex:
 * "+"
 * "-"
 * "+10"
 * "9"
 * "-10"
 * "+-2"            ->  0
 * "-+2"            ->  0
 * "    010"        ->  10
 * "    010  "      ->  10
 * "  -0012a42"     ->  -12
 * "-2147483648"    ->  -2147483648
 * "2147483648"     ->  2147483647
 * "-2147483649"    ->  -2147483649
 */
public class _008StringToInteger_atoi {

    /**
     * 异常判断才是重点
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int startIndex = 0;
        while (str.charAt(startIndex) == ' ') {
            startIndex++;
        }

        boolean isNegative = str.charAt(startIndex) == '-';

        long result = 0;
        for (int i = startIndex; i < str.length(); i++) {
            if (i == startIndex && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            result = result * 10 + str.charAt(i) - '0';
            if (!isNegative && result > 0x7fffffff) {
                return 0x7fffffff;
            }
            if (isNegative && -result < 0x80000000) {
                return 0x80000000;
            }
        }
        return (int) (isNegative ? -result : result);
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-10"));
        System.out.println(Integer.valueOf("-2147483648"));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("2147483648"));
    }
}
