package algorithm_basic_accumulation.leetcode;

/**
 * Created by HYH on 2017/4/6.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * <p>
 * 动态规划的一种变形
 */
public class _010RegularExpressionMatching {

    /**
     * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
     * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
     * 3, If p.charAt(j) == '*': here are two sub conditions:
     *      3-1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]
     *            //这种情况a*会被标记为0个来计算, in this case, a* only counts as empty
     *      3-2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
     *              dp[i][j] = dp[i-1][j]        //这种情况下，会被认为是一个，in this case, a* counts as multiple a
     *              or dp[i][j] = dp[i][j-1]    //这种情况下，会被认为是多个， in this case, a* counts as single a
     *              or dp[i][j] = dp[i][j-2]    //这种情况下，会被认为是没有， in this case, a* counts as empty
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch_DP(String s, String p) {
        if (s == null || p == null) return false;

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;
        // 将*开头的标记出来，可能都为空的情况
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }


        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    // 等于左上角格子
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == s.charAt(i)) {
                    // 等于左上角格子
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        // 若被*号描述的字符不相等的话，就掉过这个字符和*符号
                        // 等于左边第二个格子
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // 若被*号描述的字符相等的话（'.'符号也算相等）
                        // 若不要*符号成立，则有*符号也成立
                        // 若未考虑最新加进来时候成立，则加上这个相等字符也是成立的
                        // 若不考虑这个字符和*符号可以成立，则跳过这个字符和*符号也成立，
                        // 等于左边第二个格子、左边第一个格子、上面一个格子的或
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch_DP("test", ".*"));
    }
}
