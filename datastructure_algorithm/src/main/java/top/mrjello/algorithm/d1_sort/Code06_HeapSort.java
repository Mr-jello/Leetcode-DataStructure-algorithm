package top.mrjello.algorithm.d1_sort;

/**
 * @author jason@mrjello.top
 * @date 2023/7/15 16:20
 */
public class Code06_HeapSort {
    /**
     * 堆排序
     * 1. 如果只是建立堆的过程，时间复杂度为O(N)
     * 2. 时间复杂度为O(N*logN)
     * 3. 额外空间复杂度为O(1)
     * 4. 不稳定
     * 5. 优先级队列结构，就是堆结构
     */
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i); // 0~i形成大根堆 O(logN)
//        }
        // 优化：从下往上建立大根堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr,i,arr.length); // 0~i形成大根堆 O(logN)
        }

        int heapSize = arr.length;
        swap(arr,0,--heapSize); // 0位置和最后一个位置交换，heapSize减一
        while(heapSize > 0){
            heapify(arr,0,heapSize); // 0~heapSize-1形成大根堆 O(logN)
            swap(arr,0,--heapSize); // 0位置和最后一个位置交换，heapSize减一 O(1)
        }
    }


    /**
     * 从index位置，往下看，不断的下沉
     * 停：较大的孩子都不再比index位置的数大
     * @param arr 数组
     * @param index 当前的位置
     */
    private static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     * 从index位置，往下看，不断的下沉
     * 停：较大的孩子都不再比index位置的数大
     * @param arr 数组
     * @param index 当前的位置
     * @param heapSize 堆的大小
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // 左孩子的下标
        while (left < heapSize) { // 左孩子没有越界，并且下方还有孩子
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left; // 右孩子不越界，且右孩子比左孩子大
            largest = arr[largest] > arr[index] ? largest : index; // 左右孩子中较大的值和index位置的值比较
            if (largest == index) { // index位置的值比左右孩子都大，停止下沉
                break;
            }
            swap(arr, largest, index); // index位置的值比左右孩子小，和较大的孩子交换
            index = largest; // index位置更新为较大的孩子的位置
            left = index * 2 + 1; // 左孩子的下标
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i]= arr[j];
        arr[j] = tmp;
    }
}
