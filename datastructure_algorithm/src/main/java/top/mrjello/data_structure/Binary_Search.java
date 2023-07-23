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
