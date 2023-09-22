package top.mrjello.data_structure;


import org.junit.jupiter.api.Test;

/**
 * @author jason@mrjello.top
 * @date 2023/7/6 2:30
 */
public class Binary_Search {
    /**
     * 二分查找
     * @param arr 待查找数组
     * @param target 目标值
     * 时间复杂度：O(logN)
     * 空间复杂度：O(1)
     * 流程：0~N-1范围上，取中间值，如果中间值等于目标值，返回中间值下标，如果中间值大于目标值，右边界左移，如果中间值小于目标值，左边界右移
     */
    public static void binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (right + left) / 2;
            if (arr[mid] == target) {
                System.out.println("target index: " + mid);
                //return;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target){
                left = mid + 1;
            }
        }
    }

    /**
     * Given a sorted array containing duplicates, count the number of occurrences of a given element.
     * For this assignment, we will use a list of integers. Please see the example below
     * @param arr sorted arr
     * @param target count how many elements in array
     */
    public static int findFirstIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int firstIndex = -1;
        while ( left <= right ) {
            int mid = (left + right ) / 2;
            if (arr[mid] == target) {
                firstIndex = mid;
                right = mid - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return firstIndex;
    }

    public static int findLastIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int lastIndex = -1;
        while ( left <= right ) {
            int mid = (left + right ) / 2;
            if (arr[mid] == target) {
                lastIndex = mid;
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return lastIndex;
    }

    public static int countElements(int[] arr, int target) {
        if (arr == null) {
            return 0;
        }
        int firstIndex = findFirstIndex(arr, target);
        int lastIndex =  findLastIndex(arr, target);
        if (firstIndex == -1 || lastIndex == -1) {
            return 0;
        }
        return lastIndex - firstIndex + 1;
    }

    /**
     * Assume a “Rotated Sorted Array.” Please see an example below.
     * Return the index of the integer when it is found or -1 if it does not exist. This list will NOT have duplicates.
     * A rotated sorted array is an array that has a sorted list at first then it breaks and has another sorted list.
     * @param
     * @return the index of first peak element
     */



    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) {
            System.out.println("target index: " + 0);
            return 0;
        }
        int start = 0;
        int end = nums.length -1;
        if (nums[start] > nums[start + 1]){
            System.out.println("target index: " + start);
            return start;
        }
        if (nums[end] > nums[end - 1]){
            System.out.println("target index: " + end);
            return end;
        }
        while (start < end){
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                System.out.println("target index: " + mid);
                return mid;
            }else if(nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]){
                start = mid;
            }else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]){
                end = mid;
            }else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]){
                start = mid;
            }
        }
        System.out.println("target index: " + -1);
        return 0;
    }


    @Test
    public void test(){
        int[] arr = {4, 0, 5,4, 2, 1, 2, 1, 2, 1};
        findPeakElement(arr);
    }

}
