package top.mrjello.test;

import org.junit.Test;
import top.mrjello.algorithm.d1_sort.Code03_InsertionSort;
import top.mrjello.utils.GenAndCopyRandomArray;
import top.mrjello.utils.CompareAndEqual;


/**
 * @author jason@mrjello.top
 * @date 2023/7/6 21:59
 */
public class TestTwoMethod {



    @Test
    public void testTwoMethod(){
        int testTime = 100;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTime; i++){
            int[] arr1 = GenAndCopyRandomArray.generateRandomArray(maxSize, maxValue);
            int[] arr2 = GenAndCopyRandomArray.copyArray(arr1);
            //用于测试的方法A
            Code03_InsertionSort.insertionSort(arr1);
            //用于测试的方法B,此方法为比较稳定的算法
            CompareAndEqual.comparator(arr2);

            if (!CompareAndEqual.twoArrayIsEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Work!" : "Error!");
    }
}
