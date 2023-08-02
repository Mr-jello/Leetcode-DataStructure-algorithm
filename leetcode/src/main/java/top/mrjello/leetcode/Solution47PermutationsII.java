package top.mrjello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
Given a collection of numbers, nums, that might contain duplicates, return all
possible unique permutations in any order.


 Example 1:


Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]


 Example 2:


Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]



 Constraints:


 1 <= nums. Length <= 8
 -10 <= nums[i] <= 10


 Related Topics Array Backtracking 👍 7822 👎 136

*/

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution47PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums. length == 0) {
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
        // 用一个数组记录哪些数字已经被使用过了
        boolean[] visited = new boolean[21];
        // 从 i 开始，每个数字都尝试放在 i 位置
        for (int j = i; j < nums.length; j++) {
            // 如果这个数字没有被使用过
            // nums[j] + 10 是为了防止负数
            if (!visited[nums[j] + 10]) {
                visited[nums[j] + 10] = true;
                swap(nums, i, j);
                process(nums, i + 1, res);
                swap(nums, i, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
