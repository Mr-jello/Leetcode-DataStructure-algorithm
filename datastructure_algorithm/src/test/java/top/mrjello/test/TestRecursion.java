package top.mrjello.test;

import org.junit.Test;


import java.util.*;


/**
 * @author jason@mrjello.top
 * @date 2023/7/7 18:37
 */
public class TestRecursion {

    @Test
    public void test(){
        int[] arr = {5,7,3,5,2,6,1};
         List<Integer> list = countSmaller(arr);
        System.out.println(list);
    }


    public List<Integer> countSmaller(int[] nums) {
        return null;
    }




//    public List<Integer> countSmaller(int[] nums) {
//        if (nums.length < 2){
//            return new ArrayList<>();
//        }
//        int[] res = new int[nums.length];
//        int[] tmp = new int[nums.length];
//        int[] index = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            index[i] = i;
//        }
//        process(nums, 0, nums.length - 1, res, tmp, index);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < res.length; i++) {
//            list.add(res[i]);
//        }
//        return list;
//    }
//
//    public void process(int[] nums, int i, int i1, int[] res, int[] tmp, int[] index) {
//        if (i == i1){
//            return;
//        }
//        int mid = i + ((i1 - i) >> 1);
//        process(nums, i, mid, res, tmp, index);
//        process(nums, mid + 1, i1, res, tmp, index);
//        merge(nums, i, mid, i1, res, tmp, index);
//    }
//
//    public void merge(int[] nums, int i, int mid, int i1, int[] res, int[] tmp, int[] index) {
//        int p1 = i;
//        int p2 = mid + 1;
//        int i2 = 0;
//        while (p1 <= mid && p2 <= i1){
//            if (nums[index[p1]] <= nums[index[p2]]){
//                tmp[i2++] = index[p1++];
//            }else {
//                res[index[p1]] += i1 - p2 + 1;
//                tmp[i2++] = index[p2++];
//            }
//        }
//        while (p1 <= mid){
//            tmp[i2++] = index[p1++];
//        }
//        while (p2 <= i1){
//            tmp[i2++] = index[p2++];
//        }
//        for (int j = 0; j < i2; j++) {
//            index[i + j] = tmp[j];
//        }
//    }
}
