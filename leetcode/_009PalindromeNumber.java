package algorithm_basic_accumulation.leetcode;

/**
 * Created by HYH on 2017/4/4.
 * <p>
 * 判断一个数字是否是回文
 * 负数肯定不是回文
 * <p>
 * 2147483647，用int来存的话会溢出
 */
public class _009PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long palindrome = 0;
        int tmp = x;
        while (tmp > 0) {
            palindrome = palindrome * 10 + tmp % 10;
            tmp /= 10;
        }

        while (palindrome > 0) {
            if (palindrome % 10 != x % 10) {
                return false;
            }
            palindrome /= 10;
            x /= 10;
        }

        return true;
    }

    public static boolean isPalindrome_easy(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        // 节省迭代，到一半直接进行比较
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }
}
