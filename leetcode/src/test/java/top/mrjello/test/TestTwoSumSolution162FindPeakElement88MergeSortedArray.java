package top.mrjello.test;

import org.junit.Test;
import top.mrjello.utils.GenAndCopyRandomArray;
import top.mrjello.leetcode.Solution162FindPeakElement;

import java.util.Arrays;

/**
 * @author jason@mrjello.top
 * @date 2023/7/7 1:06
 */
public class TestTwoSumSolution162FindPeakElement88MergeSortedArray {

    @Test
    public void testTwoMethod(){
        int testTime = 10;
        int maxSize = 10;
        int maxValue = 100;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = GenAndCopyRandomArray.generateRandomArray(maxSize, maxValue);

            int peakElement1 = Solution162FindPeakElement.findPeakElement(arr1);
            System.out.println(Arrays.toString(arr1) + " peakElement1 = " + peakElement1);

        }
    }


}
