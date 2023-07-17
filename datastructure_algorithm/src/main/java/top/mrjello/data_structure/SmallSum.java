package top.mrjello.data_structure;

/**
 * @author jason@mrjello.top
 * @date 2023/7/7 21:46
 */
public class SmallSum {
    /**
     *小和问题：数组中每个数左边比当前数小的数的和依次相加
     * 例：[1,3,4,2,5]
     * 1左边比1小的数：无
     * 3左边比3小的数：1
     * 4左边比4小的数：1,3
     * 2左边比2小的数：1
     * 5左边比5小的数：1,3,4,2
     * 小和：1+1+3+1+1+3+4+2=16
     * 转换思路：每个数右边比当前数大的数的和依次相加
     * 例：[1,3,4,2,5]
     * 1右边比1大的数：3,4,2,5 => 产生了4个1的小和
     * 3右边比3大的数：4,5 => 产生了2个3的小和
     * 4右边比4大的数：5 => 产生了1个4的小和
     * 2右边比2大的数：5 => 产生了1个2的小和
     * 5右边比5大的数：无 => 产生了0个5的小和
     * 小和：4*1+2*3+1*4+1*2+0*5=16
     * 转换为归并排序问题
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        // 递归调用
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求小和返回
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        // 中间位置
        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid) + process(arr, mid + 1, r) + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0; // 小和
        while (p1 <= mid && p2 <= r){
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 两个必有且只有一个越界
        while (p1 <= mid){
            tmp[i++] = arr[p1++];
        }
        while (p2 <= r){
            tmp[i++] = arr[p2++];
        }
        // 将tmp数组的值赋值给arr数组
        for (i = 0; i < tmp.length; i++) {
            arr[l + i] = tmp[i];
        }
        return res;
    }

}
