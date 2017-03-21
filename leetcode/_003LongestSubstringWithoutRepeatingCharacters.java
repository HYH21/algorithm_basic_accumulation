package algorithm_basic_accumulation.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by HYH on 2017/3/21.
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 * "pwke" is a subsequence and not a substring.
 */
public class _003LongestSubstringWithoutRepeatingCharacters {

    /**
     * Brute Force: Time:O(n^2), Space:O(1)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < s.length(); i ++) {
            for(int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))) {
                    break;
                } else {
                    set.add(s.charAt(j));
                }
            }

            result = Math.max(result, set.size());
            set.clear();
        }
        return result;
    }


    /**
     * slidingWindow: Time: O(2n)<-O(n), Space:O(min(m,n))
     *
     * @param s
     * @return
     */
    public int slidingWindow_lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (set.contains(s.charAt(j))){
                // 包含，i右移并移除记录
                set.remove(s.charAt(i++));
            } else {
                // 不包含，j右移并记录
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

    /**
     * slidingWindowOptimized: Time: O(n), Space:O(min(m,n))
     *
     * Instead of using a set to tell if a character exists or not,
     * we could define a mapping of the characters to its index.
     * Then we can skip the characters immediately when we found a repeated character.
     *
     * @param s
     * @return
     */
    public int slidingWindowOptimized_lengthOfLongestSubstring(String s) {
        int length = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                // 优化i++，直接跳到j相同字母的前一个位置
                i = Math.max(map.get(s.charAt(j)), i);
            }
            // 统计长度
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
