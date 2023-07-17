package top.mrjello.data_structure;


/**
 * @author jason@mrjello.top
 * @date 2023/7/7 18:30
 */
public class Recursion_GetMaxOfArray {
    /**
     * 递归函数：求arr[l...r]范围上的最大值
     * @param arr 数组
     * @return 最大值
     *
     * master公式：T(N) = a*T(N/b) + O(N^d)
         * log(b,a) < d -> 复杂度为O(N^d)
         * log(b,a) > d -> 复杂度为O(N^log(b,a))
         * log(b,a) = d -> 复杂度为O(N^d * logN)

     * 此方法的master公式：T(N) = 2*T(N/2) + O(1)
     * log(2,2) = 1 > 0 -> 复杂度为O(N^1) = O(N)
     */
    public static int getMax(int[] arr){
        return process(arr, 0,arr.length - 1);

    }

    /**
     * 递归函数：求arr[l...r]范围上的最大值
     * @param arr 数组
     * @param l 左边界
     * @param r 右边界
     * @return 最大值
     */
    public static int process(int[] arr, int l, int r) {
        if(l == r){
            return arr[l];
        }
        int mid = l + ((r - l) >> 1); // 二进制右移一位，相当于除以2
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }
}
