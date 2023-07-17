package top.mrjello.leetcode;

/**
Given an integer array nums, return the number of reverse pairs in the array.

 A reverse pair is a pair (i, j) where:


 0 <= i < j < nums.length and
 nums[i] > 2 * nums[j].



 Example 1:


Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1


 Example 2:


Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1



 Constraints:


 1 <= nums.length <= 5 * 10⁴
 -2³¹ <= nums[i] <= 2³¹ - 1


 Related Topics Array Binary Search Divide and Conquer Binary Indexed Tree
Segment Tree Merge Sort Ordered Set 👍 5118 👎 231
 * @author jason

 */

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution493ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return process(nums, 0, nums.length - 1);
    }

    public static int process(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid) + process(nums, mid + 1, r) + merger(nums, l, mid, r);
    }

    public static int merger(int[] nums, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            if (nums[p1] / 2.0 > nums[p2]) {
                res += m - p1 + 1;
                p2++;
            } else {
                p1++;
            }
        }
        p1 = l;
        p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[i++] = nums[p1] > nums[p2] ? nums[p2++] : nums[p1++];
        }
        while (p1 <= m) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (i = 0; i < help.length; i++){
            nums[l + i] = help[i];
        }
        return res;
    }
}

//runtime:68 ms
//memory:49.9 MB
//leetcode submit region end(Prohibit modification and deletion)
