package top.mrjello.algorithm.d1_sort;


import org.junit.jupiter.api.Test;

/**
 * @author jason@mrjello.top
 * @date 2023/7/6 1:44
 */
public class Code03_InsertionSort {
    /**
     * 插入排序
     * @param arr 待排序数组
     * 时间复杂度(最差)：O(N^2),最好情况：O(N)
     * 空间复杂度：O(1)
     * 二分算法时间复杂度：O(NlogN)
     * 稳定性：稳定
     * 流程：0~0范围上，小的左移交换，0~1范围上，小的左移交换，0~2范围上，小的左移交换，...，0~N-1范围上，小的左移交换
     * 类似于打扑克牌，左手拿牌，右手有序，每次拿到新牌，从右往左比较，小的左移交换，直到拿到最后一张牌
     */
    public static void insertionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //0-i范围上，小的左移交换
        for(int i = 1; i < arr.length; i++){
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--){
                swap(arr, j, j + 1);
            }
        }
    }


    public static void swap(int[] arr, int i, int j){
        if (i == j) {
            return;
        }
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[j] ^ arr[i];
    }

    @Test
    public void test(){
        int[] arr = {1, 3, 2, 5, 4, 6, 11, 9, 8, 7, 10};
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }



    }
}
