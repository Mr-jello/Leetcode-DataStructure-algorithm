package top.mrjello.leetcode;

/**
Given an integer array nums, in which exactly two elements appear only once and
all the other elements appear exactly twice. Find the two elements that appear
only once. You can return the answer in any order.

 You must write an algorithm that runs in linear runtime complexity and uses
only constant extra space.


 Example 1:


Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.


 Example 2:


Input: nums = [-1,0]
Output: [-1,0]


 Example 3:


Input: nums = [0,1]
Output: [1,0]



 Constraints:


 2 <= nums.length <= 3 * 10⁴
 -2³¹ <= nums[i] <= 2³¹ - 1
 Each integer in nums will appear twice, only two integers will appear once.


 Related Topics Array Bit Manipulation 👍 5173 👎 215

*/

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution260SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int eor = 0;
        for(int cur : nums){
            eor ^= cur;
        }
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for(int cur2 : nums){
            if((cur2 & rightOne) != 0){
                onlyOne ^= cur2;
            }
        }
        return new int[] {onlyOne, eor ^ onlyOne};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//执行耗时:1 ms,击败了100.00% 的Java用户
//内存消耗:44.5 MB,击败了46.40% 的Java用户
