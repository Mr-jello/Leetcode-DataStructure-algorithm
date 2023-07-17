package top.mrjello.algorithm.d1_sort;

/**
 * @author jason@mrjello.top
 * @date 2023/7/7 19:59
 */
public class Code04_MergeSort {
    /**
     * 归并排序master公式：T(N) = 2 * T(N/2) + O(N)
     * 时间复杂度：O(N * logN)
     * 空间复杂度：O(N)
     * 稳定性：稳定
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 递归调用
        process(arr, 0, arr.length - 1);
    }

    // 递归调用
    public static void process(int[] arr, int l, int r) {
        // 递归终止条件
        if (l == r) {
            return;
        }
        // 中间位置
        int mid = l + ((r - l) >> 1);
        // 左边排序
        process(arr, l, mid);
        // 右边排序
        process(arr, mid + 1, r);
        // 合并
        merge(arr, l, mid, r);
    }
    // 合并
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = 0; // tmp数组的下标
        int p1 = l; // 左边数组的下标
        int p2 = mid + 1; // 右边数组的下标
        while (p1 <= mid && p2 <= r) {
            tmp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 两个必有且只有一个越界
        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            tmp[i++] = arr[p2++];
        }
        // 将tmp数组的值赋值给arr数组
        for (i = 0; i < tmp.length; i++) {
            arr[l + i] = tmp[i];
        }

    }


}
