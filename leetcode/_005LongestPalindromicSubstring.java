package algorithm_basic_accumulation.leetcode;

/**
 * Created by HYH on 2017/3/23.
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 */
public class _005LongestPalindromicSubstring {

    ///////////////////////////////////////////////////////////////////////////
    // 未实现算法讨论
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 1. Brute Force: 找出所有的子串O(n^2)，然后判断这个是否是一个回文O(n)，综合O(n^3)
     * 2. Longest Common Substring: 反转字符，找最长公共子串，暴力需要O(n^3)
     * 3. Dynamic Programming：动态规划，P(i,j)=(P(i+1,j−1) and S​i==S​j)，Time: O(n^2), Space:O(n^2)
     * 4. Manacher's Algorithm:  Time: O(n)
     *
     * //TODO Manacher's Algorithm， 最长公共子串最快的算法是什么，动态规划实现
     */

    ///////////////////////////////////////////////////////////////////////////
    // 已实现算法
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Expand Around Center: Time:O(n^2), Space:O(1)
     *
     * 实现得很狼狈，接下来的而一个方法进行优化，使代码更加易读
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null) return null;
        int max_length = 0;
        int startMark = 0, endMark = 0;

        for (int i = 0; i < s.length(); i++) {
            int front = i, last = i, commentLength = 1;
            // 定位到一个字符的时候，先向后检查是否存在相同的字符，
            // 若碰到相同的字符则，则将这一系列相同的字符组合成中间，接下来进行扩展判断
            for(int k = i + 1; k < s.length(); k++) {
                if(s.charAt(front) == s.charAt(k)) {
                    last = k;
                    commentLength++;
                    if(commentLength > max_length){
                        max_length = commentLength;
                        startMark = front;
                        endMark = last;
                    }
                } else {
                    break;
                }
            }

            // 从中间想两边扩展，尽量长地去获得一个回文子串
            // 中间这个可以是一个字符，也可以是一段字符
            for (int j = 1; front - j >= 0 && last + j < s.length(); j++) {
                if (s.charAt(front - j) == s.charAt(last + j)) {
                    if (j * 2 + commentLength > max_length) {
                        startMark = front - j;
                        endMark = last + j;
                        max_length = j * 2 + commentLength;
                    }
                } else {
                    break;
                }
            }
        }
        return s.substring(startMark, endMark+1);
    }

    /**
     * Expand Around Center: Time:O(n^2), Space:O(1)
     *
     * 易读版本的算法
     * @param s
     * @return
     */
    public String expandCenter_longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 只考虑一个字符和两个字符作为中间量
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abadd"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
