package top.mrjello.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.


 Example 1:
 Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 Example 2:
 Input: nums = [0,1]
Output: [[0,1],[1,0]]

 Example 3:
 Input: nums = [1]
Output: [[1]]


 Constraints:


 1 <= nums. Length <= 6
 -10 <= nums[i] <= 10
 All the integers of nums are unique.


 Related Topics Array Backtracking 👍 16577 👎 268
 * @author Jason

 */

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        process(nums, 0, res);
        return res;
    }
    public static void process(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            res.add(tmp);
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            process(nums, i + 1, res);
            swap(nums, i, j);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
