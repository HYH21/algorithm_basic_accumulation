package algorithm_basic_accumulation.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HYH on 2017/3/21.
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class _001TwoSum {

    /**
     * Brute Force: Time:O(n^2), Space:O(1);
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    /**
     * Two-pass Hash Table: Time:O(n), Space:O(n);
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_TwoPass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 注意index不能是同一个
            if(map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No sum solution");
    }


    /**
     * One-pass Hash Table: Time:O(n), Space:O(n);
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_OnePass(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 一边计算一边检查是否正确，要求正确结果只有一个，而且数字户不会重复出现
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No sum solution");
    }
}
