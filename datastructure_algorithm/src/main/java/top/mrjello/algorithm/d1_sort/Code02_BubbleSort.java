package top.mrjello.algorithm.d1_sort;
import org.junit.Test;


/**
 * @author jason@mrjello.top
 * @date 2023/7/5 21:33
 */
public class Code02_BubbleSort {

    /**
     * BubbleSort
     * @param arr unsorted array
     * time complexity: O(N^2), best case: O(N)
     * space complexity: O(1)
     * stable: yes
     * 流程：1. 0到1位置上，谁大谁往后挪，1到2位置上，谁大谁往后挪，以此类推确定最大值排到最后 0 - N-1
     *      2. 0到1位置上，谁大谁往后挪，1到2位置上，谁大谁往后挪，以此类推确定第二大值排到倒数第二个位置 0 - N-2
     *
     */

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i > 0 ; i--) {
            for(int j = 0; j < i; j++){
                if (arr[j] > arr[j + 1]){
                    swap(arr,j,j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){

        /*
          1. a ^ b ? a = b => 0 a != b => 1(相同为0，不同为1)
          2. 亦可理解为无进位相加
          3. 0 ^ a = a，a ^ a = 0
          4. i = a, j = b
             arr[i] = arr[i] ^ arr[j] => arr[i] = a ^ b, arr[j] = b
             arr[j] = arr[i] ^ arr[j] => arr[i] = a ^ b, arr[j] = a ^ b ^ b = a ^ 0 = a
             arr[i] = arr[i] ^ arr[j] => arr[i] = a ^ b ^ a = b ^ 0 = b
          5. a ^ b: a和b的值可以相同，但是地址需要不同，不然会变成0
         */

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    /*
    1. 一个整形数组，一个数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这个数
    */
    public static void printOddTimesNum1(int[] arr){
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

    /*
    2. 一个整形数组，两个数出现了奇数次，其他数都出现了偶数次，怎么找到并打印这两个数

        A = 0011 1100
        B = 0000 1101
        -----------------
        A&B = 0000 1100
        A | B = 0011 1101
        A ^ B = 0011 0001
        ~A= 1100 0011
      ==================================================
        ＆	如果相对应位都是1，则结果为1，否则为0	（A＆B），得到12，即0000 1100
        |	如果相对应位都是 0，则结果为 0，否则为 1	（A | B）得到61，即 0011 1101
        ^	如果相对应位值相同，则结果为0，否则为1	（A ^ B）得到49，即 0011 0001
        〜	按位取反运算符翻转操作数的每一位，即0变成1，1变成0。	（〜A）得到-61，即1100 0011
        << 	按位左移运算符。左操作数按位左移右操作数指定的位数。	A << 2得到240，即 1111 0000
        >> 	按位右移运算符。左操作数按位右移右操作数指定的位数。	A >> 2得到15即 1111
        >>> 	按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。	A>>>2得到15即0000 1111
      ==================================================
                    eor = 1010111100
                   ~eor = 0101000011
               ~eor + 1 = 0101000100
       eor & (~eor + 1) = 0000000100
    */
    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i]; // eor = a ^ b
        }
        //eor ！= 0，eor 必然有一个位置上是1
        int rightOne = eor & (~eor + 1); // 提取出最右的1
        int onlyOne = 0; // eor'
        for (int cur : arr) {
            if ((cur & rightOne) != 0){ // 该位置上是1的数, 或者 cur & rightOne = 0
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }



    @Test
    public void testPrintOddTimesNum2(){
        int[] arr = {1,1,1,1,3,3,3,7,7,7,2,2};
        printOddTimesNum2(arr);
    }

}
