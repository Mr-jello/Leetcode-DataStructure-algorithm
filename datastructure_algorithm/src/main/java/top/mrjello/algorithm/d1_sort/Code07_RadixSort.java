package top.mrjello.algorithm.d1_sort;

/**
 * @author jason@mrjello.top
 * @date 2023/7/15 20:06
 */
public class Code07_RadixSort {

    /**
     * 基数排序
     * <p>
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * <p>
     * 稳定性：稳定
     * <p>
     * 基数排序是桶排序的扩展，它的基本思想是：将整数按位数切割成不同的数字，然后按每个位数分别比较。
    */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxBits(arr));
    }

    /**
     * @param arr 待排序数组
     * @param L   左边界
     * @param R   右边界
     * @param digit 数组中最大值有几位
     */
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10; // 基数
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1]; // 桶
        // 有多少位就相当于进出桶多少次
        for (int d = 1; d <= digit; d++) {
            // 10个空间的桶
            // d=1 个位数，d=2 十位数，d=3 百位数
            // count[0] 当前位（d位）是0的数字有多少个
            // count[1] 当前位（d位）是0和1的数字有多少个
            // count[2] 当前位（d位）是0、1和2的数字有多少个
            // count[i] 当前位（d位）是0、1、2、...、i的数字有多少个
            // 分片统计
            int[] count = new int[radix]; //count[0..9]
            // 依次遍历数组，统计当前位（d位）是0、1、2、...、i的数字有多少个
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            // 将数组改变为前缀和数组
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            // 从右往左遍历数组，将数组中的元素放入桶中
            // 从右往左遍历，保证排序的稳定性
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }
        }
    }


    /**
     * @param arr 待排序数组
     * @return 数组中最大值有几位
     * 例如：arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
     * 数组中最大值为10，10有两位，所以返回2
     */
    public static int maxBits(int[] arr) {
        int max = Integer.MIN_VALUE; // 32位最小值（系统最小值） 0x80000000
        // 依次遍历数组，找到最大值
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // 通过最大值，计算出最大值的位数
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * @param x 数字
     * @param d 位数
     * @return 数字x的第d位
     * Math.pow(10, d - 1) 10的d-1次方
     * x / ((int) Math.pow(10, d - 1))  x除以10的d-1次方
     * (x / ((int) Math.pow(10, d - 1))) % 10  x除以10的d-1次方的余数
     * 例如：x=12345，d=3
     * Math.pow(10, d - 1) = 100
     * x / ((int) Math.pow(10, d - 1)) = 12345 / 100 = 123
     * (x / ((int) Math.pow(10, d - 1))) % 10 = 123 % 10 = 3
     */
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }


}
