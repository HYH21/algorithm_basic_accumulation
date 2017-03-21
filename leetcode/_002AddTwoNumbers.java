package algorithm_basic_accumulation.leetcode;

/**
 * Created by HYH on 2017/3/21.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class _002AddTwoNumbers {

    /**
     * brute: Time: O(max(m,n)), Space:(max(m,n));
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode point_l1 = l1, point_l2 = l2;
        ListNode result = null, point_result = null;
        int carryNum = 0;

        while (point_l1 != null || point_l2 != null) {
            // 两个数字可能会不同长度
            int sum = (point_l1 == null ? 0 : point_l1.val) + (point_l2 == null ? 0 : point_l2.val)
                    + carryNum;
            carryNum = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);

            if(result  == null) {
                result = node;
                point_result = result;
            } else {
                point_result.next = node;
                point_result = node;
            }

            point_l1 = point_l1 == null ? null : point_l1.next;
            point_l2 = point_l2 == null ? null : point_l2.next;
        }

        if(carryNum == 1) {
            point_result.next = new ListNode(1);
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
