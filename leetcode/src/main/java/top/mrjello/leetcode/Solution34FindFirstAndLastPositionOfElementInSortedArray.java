package top.mrjello.leetcode;

/**
Given an array of integers nums sorted in non-decreasing order, find the
starting and ending position of a given target value.

 If target is not found in the array, return [-1, -1].

 You must write an algorithm with O(log n) runtime complexity.


 Example 1:
 Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

 Example 2:
 Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

 Example 3:
 Input: nums = [], target = 0
Output: [-1,-1]


 Constraints:


 0 <= nums.length <= 10⁵
 -10⁹ <= nums[i] <= 10⁹
 nums is a non-decreasing array.
 -10⁹ <= target <= 10⁹


 Related Topics Array Binary Search 👍 17490 👎 427

*/

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution34FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                int left = mid;
                int right = mid;
                while (left >= 0 && nums[left] == target){
                    left--;
                }
                while (right <= nums.length - 1 && nums[right] == target){
                    right++;
                }
                return new int[]{left + 1, right - 1};
            } else if (nums[mid] > target){
                end = mid - 1;
            } else if (nums[mid] < target){
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
