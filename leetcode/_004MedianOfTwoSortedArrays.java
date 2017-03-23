package algorithm_basic_accumulation.leetcode;

/**
 * Created by HYH on 2017/3/23.
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * <p>
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class _004MedianOfTwoSortedArrays {

    /**
     * 使用归并排序的一半： Time:O((m+n)/2), Space:O((m+n)/2)
     * <p>
     * 刷出一遍TLE，原因未明
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int oddNumFlag = (totalLength) & 0x01;
        int midIndex = totalLength >> 1;

        int[] assistArr = new int[midIndex + 1];

        int index1 = 0, index2 = 0, count = 0;
        // 归并算法的和合并操作，合并到一半就可以找到中位数了
        while (count < midIndex + 1 && index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                assistArr[count++] = nums1[index1++];
            } else {
                assistArr[count++] = nums2[index2++];
            }
        }
        while (count < midIndex + 1 && index1 < nums1.length) {
            assistArr[count++] = nums1[index1++];
        }
        while (count < midIndex + 1 && index2 < nums2.length) {
            assistArr[count++] = nums2[index2++];
        }

        if (oddNumFlag == 1) {
            return assistArr[midIndex];
        } else {
            return 0.5 * (assistArr[midIndex - 1] + assistArr[midIndex]);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }


}
