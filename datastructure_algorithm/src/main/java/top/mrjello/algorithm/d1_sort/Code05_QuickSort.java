package top.mrjello.algorithm.d1_sort;

/**
 * @author jason@mrjello.top
 * @date 2023/7/9 22:35
 */
public class Code05_QuickSort {
    /**
     * 快速排序
     * 时间复杂度：O(N*logN)
     * 空间复杂度：O(logN)
     * 稳定性：不稳定
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 递归调用
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归调用
     * @param arr  待排序数组
     * @param L   左边界
     * @param R  右边界
     */
    public static void quickSort(int[] arr, int L, int R){
        if (L < R){
            //随机选取一个数与最后一个做交换
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            //获取分区点 以分区点为界限，左边的数都小于等于分区点，右边的数都大于等于分区点
            //返回的是两个分区点的下标
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1); //递归调用左边的分区 <区域
            quickSort(arr, p[1] + 1, R); //递归调用右边的分区 >区域
        }
    }

    /**
     * 获取分区点
     * @param arr  待排序数组
     * @param L   左边界
     * @param R  右边界
     * @return  返回分区点的下标
     */
    public static int[] partition(int[] arr, int L, int R){
        int less = L - 1; // <区域的右边界
        int more = R; // >区域的左边界
        while (L < more){ //L表示但钱数的位置 arr【R】
            if(arr[L] < arr[R]){
                swap(arr, ++less, L++); //当前数小于分区点，将当前数与<区域的下一个数交换，同时将<区域右扩一个位置
            }else if (arr[L] > arr[R]){
                swap(arr, --more, L); //当前数大于分区点，将当前数与>区域的前一个数交换，同时将>区域左扩一个位置
            }else {
                L++; //当前数等于分区点,跳到下一个数
            }
        }
        swap(arr, more, R); //将分区点与>区域的第一个数交换
        return new int[]{less + 1, more}; //返回分区点的下标
    }

    /**
     * 交换数组中两个数的位置
     * @param arr  数组
     * @param i  位置i
     * @param j  位置j
     */
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j]; //将i位置的数与j位置的数交换
        arr[j] = tmp;
    }
}
