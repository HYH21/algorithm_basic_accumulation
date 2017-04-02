package algorithm_basic_accumulation.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HYH on 2017/3/31.
 * <p>
 * 最长重复子串，蛮力法，后缀数组法
 * http://www.cnblogs.com/ider/p/longest-common-substring-problem-optimization.html
 */
public class Meitu_LongestSubStr {

    /**
     * 蛮力法，时间复杂度在O(n^3)这附近
     * 可以优化提前结束循环
     *
     * @param str
     * @return
     */
    public static String subLongestRepeatStr(String str) {
        int maxLength = 1;
        int maxIndex = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    int max = comLength(str, i, j);
                    if (max > maxLength) {
                        maxLength = max;
                        maxIndex = i;
                    }
                }
            }
        }
        return str.substring(maxIndex, maxIndex + maxLength);
    }

    private static int comLength(String str, int original, int compare) {
        int max = 0;
        int index = 0;
        while (str.charAt(original + index) == str.charAt(compare + index)) {
            max++;
            index++;
            if (original + index >= str.length() || compare + index >= str.length()) {
                break;
            }
        }
        return max;
    }

    /**
     * 后缀数组，时间复杂度在O(n^2 * log(n))
     * 思路是将后缀开头的字符相同的聚集在一起，并按长度排序，然后比较相邻的即可以找到最长重复的
     * Java实现比较曲折，因为C语言的指针可以当做字符串，并strcmp函数进行比较
     *
     * @param str
     * @return
     */
    public static String suffixArrLRS(String str) {
        char[] chars = str.toCharArray();
        HashMap<Character, List<Integer>> map = new HashMap<>(26);

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(c, l);
            }
        }

        // 这里可以不用排序，因为加进去的时候已经是从前往后加了，所以排序是从长到短的
        /*for (Character c : map.keySet()) {
            List<Integer> list = map.get(c);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 > o2 ? 1 : -1;
                }
            });
        }*/

        int maxLength = 1;
        int maxIndex = 0;
        // 这里代码很类似于蛮力法，但是这里是每个相同字母相邻长度的进行比较
        // 而蛮力法是两两都进行了比较，耗时较长
        for (Character c : map.keySet()) {
            List<Integer> list = map.get(c);
            for(int i = 0; i < list.size() - 1; i ++) {
                int temp = comLength(str, list.get(i), list.get(i + 1));
                if(temp > maxLength) {
                    maxLength = temp;
                    maxIndex = list.get(i);
                }
            }
        }
        return str.substring(maxIndex, maxIndex + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(subLongestRepeatStr("banana"));
        System.out.println(subLongestRepeatStr("abc"));
        System.out.println(suffixArrLRS("banana"));
        System.out.println(suffixArrLRS("abc"));
    }

}
