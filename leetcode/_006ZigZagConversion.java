package algorithm_basic_accumulation.leetcode;

/**
 * Created by HYH on 2017/3/29.
 *
 * 将一个字符串摆成Z字型，并按行输出
 */
public class _006ZigZagConversion {

    /**
     * 进行下标的换算，计算出一行的字符有哪些
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if(numRows == 0 || numRows == 1) return s;

        StringBuilder sb = new StringBuilder();

        int midCount = numRows - 2;

        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < s.length(); j++) {
                int base = j * numRows + midCount * j;
                if(base + i < s.length()) {
                    sb.append(s.charAt(base + i));
                }
                if(i != 0 && i != numRows - 1) {
                    int midInRow = base + numRows - 1 + (numRows - 1 - i);
                    if(midInRow < s.length()) {
                        sb.append(s.charAt(midInRow));
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 使用多个StringBuilder来进行处理，这样就不用进行下标的换算
     *
     * @param s
     * @param nRows
     * @return
     */
    public String multiBufferConvert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    public static void main(String[] args) {
        System.out.println(-10 % 3);
        //System.out.println(convert("PAYPALISHIRING", 3));
    }
}
