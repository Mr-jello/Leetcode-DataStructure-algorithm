package top.mrjello.leetcode;/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (35.58%)
 * Likes:    21409
 * Dislikes: 2420
 * Total Accepted:    1.7M
 * Total Submissions: 4.9M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 * Example 1:
 *
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 *
 * Example 2:
 *
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 *
 *
 * Constraints:
 *
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// @lc code=start
public class Solution4MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        Collections.sort(list);
        int left = 0;
        int right = list.size() - 1;
        if (list.size() == 0) {
            return 0;
        }else if (list.size() == 1) {
            return list.get(0);
        }else if (list.size() % 2 == 0){
            double mediumIndex = (left + right) * 0.5;
            int a1 =(int) Math.ceil(mediumIndex);
            int a2 =(int) Math.floor(mediumIndex);
            double rs = (list.get(a1) + list.get(a2)) * 0.5;
            return rs;
        }else {
            int mediumIndex = (left + right) / 2;
            return list.get(mediumIndex);
        }
    }
}
// @lc code=end

