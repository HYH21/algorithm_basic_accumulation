package algorithm_basic_accumulation.leetcode;

/**
 * Created by HYH on 2017/3/29.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class _007ReverseInteger {

    /**
     * 用了字符串int转换的Api，溢出也是依靠Api来进行判断的，不是很满意
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        if (s.charAt(0) == '-') {
            sb.append('-');
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') continue;
            sb.append(s.charAt(i));
        }
        try {
            return Integer.valueOf(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 使用long来判断是否超过int的最大最小值
     *
     * @param x
     * @return
     */
    public int longReverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
            //  MAX_VALUE = 0x7fffffff; MIN_VALUE = 0x80000000;
            if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }

    /**
     * @param x
     * @return
     */
    public int inteverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}
