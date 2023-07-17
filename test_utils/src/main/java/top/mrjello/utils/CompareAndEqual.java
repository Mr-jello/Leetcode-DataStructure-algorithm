package top.mrjello.utils;

/**
 * @author jason@mrjello.top
 * @date 2023/7/6 20:31
 */
public class CompareAndEqual {

    /**
     * 比较器：用于存放比较算法
     * @param arr 待排序数组
     */
    public static void comparator(int[] arr){
        java.util.Arrays.sort(arr);
    }



    /**
     * 比较两个数组是否相等
     * @param arr1 数组1
     * @param arr2 数组2
     * @return 是否相等
     */
    public static boolean twoArrayIsEqual(int[] arr1, int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
