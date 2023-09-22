package top.mrjello.algorithm.d1_sort;

import java.util.Arrays;

/**
 * @author jason@mrjello.top
 * @date 2023/7/5 20:59
 */
public class  Code01_SelectionSort {

    /**
     * SelectionSort
     * @param arr unsorted array
     * Time complexity: O(N^2), best case: O(N)
     * Space complexity: O(1)
     * Stable: No
     * 稳定性：指的是排序后，相同元素的相对位置不变
     * 流程：先在0 - N-1上找最小值，放到0位置上，再在1 - N-1上找最小值，放到1位置上，以此类推
     */
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

        // i ~ N-1
        for (int i = 0; i < arr.length - 1; i++) {
            // minimum index
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,1,3,6,4};
        selectionSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }



}
