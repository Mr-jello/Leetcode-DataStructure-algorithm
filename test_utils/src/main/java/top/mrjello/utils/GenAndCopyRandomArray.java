package top.mrjello.utils;



import java.util.Arrays;

/**
 * @author jason@mrjello.top
 * @date 2023/7/6 20:19
 */
public class GenAndCopyRandomArray {

    public static int[] generateRandomArray(int maxSize, int maxValue){

        //math.random() -> double [0,1)所有小数，等概率返回一个
        //Math.random() * N -> double [0,N)所有小数，等概率返回一个
        //(int)(Math.random() * N) -> int [0,N-1]所有整数，等概率返回一个

        int arr[] = new int[(int)((maxSize + 1) * Math.random())]; // [0, maxSize]范围上的随机长度
        for (int i = 0; i < arr.length; i++) {
            // [-maxValue, maxValue]范围上的随机数
            //arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
            arr[i] = (int)((maxValue + 1) * Math.random());

        }
        return arr;
    }


    public static int[] copyArray(int[] arr){
        if (arr == null) {
            return null;
        }
        int[] copyArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArr[i] = arr[i];
        }
        return copyArr;
    }

}
