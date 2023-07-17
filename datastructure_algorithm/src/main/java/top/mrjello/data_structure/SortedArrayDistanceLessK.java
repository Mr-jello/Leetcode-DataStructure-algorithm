package top.mrjello.data_structure;

import java.util.PriorityQueue;

/**
 * @author jason@mrjello.top
 * @date 2023/7/15 18:33
 */
public class SortedArrayDistanceLessK {
    /**
     * 给定一个几乎的有序数组arr，几乎有序是指如果把数组排好序，每个元素移动的距离不超过k，且k小于arr的长度
     * 1.先把前k+1个元素放入小根堆中，然后依次从堆中弹出元素，同时从数组中取出下一个元素放入堆中，直到数组中的元素全部放入堆中
     * 2.最后从堆中依次弹出元素，并放入数组中
     * <p>
     * 时间复杂度：O(NlogK)
     * 空间复杂度：O(K)
     * @param arr 数组
     * @param k  k
     */
    public void sortedArrayDistanceLessK(int[] arr, int k) {
        // 默认小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length, k); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++) {
            heap.add(arr[index]);
            arr[i++] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
