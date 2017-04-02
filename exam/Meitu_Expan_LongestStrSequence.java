package algorithm_basic_accumulation.exam;

/**
 * Created by HYH on 2017/4/2.
 * <p>
 * 最长公共子序列
 * https://segmentfault.com/a/1190000002641054#articleHeader11
 */
public class Meitu_Expan_LongestStrSequence {

    public static String lrs(String strA, String strB) {
        // 由于计算只涉及到两层，所以可以优化成只用个两行的数组来进行处理
        int[][] assist = new int[strA.length() + 1][strB.length() + 1];
        // 动态规划计算所有子问题
        for (int i = 1; i <= strA.length(); i++) {
            for (int j = 1; j <= strB.length(); j++) {
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) {
                    assist[i][j] = assist[i - 1][j - 1] + 1;
                } else {
                    assist[i][j] = Math.max(assist[i - 1][j], assist[i][j - 1]);
                }
            }
        }

        // 回溯
        int i = strA.length(), j = strB.length();
        StringBuilder resultSb = new StringBuilder();
        while (i > 0 && j > 0){
            if (strA.charAt(i - 1) == strB.charAt(j - 1)){
                resultSb.append(strA.charAt(i - 1));
                i--;
                j--;
            } else if (assist[i - 1][j] >= assist[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return resultSb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(lrs("AGGTAB", "GXTXAYB"));
        System.out.println(lrs("abcda", "adcba"));
    }

}
