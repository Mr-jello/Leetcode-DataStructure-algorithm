package top.mrjello.algorithm.d5_GreedyAlgorithm;

import org.junit.jupiter.api.Test;
import top.mrjello.utils.GenAndCopyRandomArray;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jason@mrjello.top
 * @date 2023/7/25 20:08
 */
public class QuickMedian {

    /**
     * 快速从一个数据流中，随时可以取得中位数
     * 1. 两个堆，一个大根堆，一个小根堆
     * 2. 如果大根堆的大小等于小根堆的大小+2，则将大根堆的堆顶元素弹出，加入小根堆
     * 3. 如果小根堆的大小等于大根堆的大小+2，则将小根堆的堆顶元素弹出，加入大根堆
     * 4. 如果大根堆为空，或者当前数字小于等于大根堆堆顶元素，则加入大根堆
     * 5. 否则加入小根堆
     * 6. 维护两个堆的大小
     * 7. 如果两个堆都为空，返回null
     * 8. 获取两个堆的堆顶元素
     * 9. 如果两个堆的元素个数之和为偶数，则返回两个堆顶元素的平均值
     * 10. 否则返回元素个数多的堆的堆顶元素
     */
    public static class MedianHolder {
        // 1. 两个堆，一个大根堆，一个小根堆
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((o1, o2) -> o1 - o2);

        /**
         * 维护两个堆的大小
         */
        private void modifyTwoHeapSize() {
            // 2. 如果大根堆的大小等于小根堆的大小+2，则将大根堆的堆顶元素弹出，加入小根堆
            if (this.maxHeap.size() == this.minHeap.size() + 2) {
                this.minHeap.add(this.maxHeap.poll());
            }
            // 3. 如果小根堆的大小等于大根堆的大小+2，则将小根堆的堆顶元素弹出，加入大根堆
            if (this.minHeap.size() == this.maxHeap.size() + 2) {
                this.maxHeap.add(this.minHeap.poll());
            }
        }

        /**
         * 添加元素
         * @param num 数字
         */
        public void addNumber(int num) {
            // 4. 如果大根堆为空，或者当前数字小于等于大根堆堆顶元素，则加入大根堆
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
                // 5. 否则加入小根堆
            }else {
                minHeap.add(num);
            }
            // 6. 维护两个堆的大小
            modifyTwoHeapSize();
        }

        /**
         * 获取中位数
         * @return 中位数
         */
        public Integer getMedian() {
            // 6. 获取两个堆的大小
            int maxHeapSize = this.maxHeap.size();
            int minHeapSize = this.minHeap.size();
            // 7. 如果两个堆都为空，返回null
            if (maxHeapSize + minHeapSize == 0) {
                return null;
            }
            // 8. 获取两个堆的堆顶元素
            Integer maxHeapHead = this.maxHeap.peek();
            Integer minHeapHead = this.minHeap.peek();
            // 9. 如果两个堆的元素个数之和为偶数，则返回两个堆顶元素的平均值
            if(((maxHeapSize + minHeapSize) & 1) == 0) {
                return (maxHeapHead + minHeapHead) / 2;
            }
            // 10. 否则返回元素个数多的堆的堆顶元素
            return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
        }
    }

    @Test
    public void testMedian() {
        int[] randomArray = GenAndCopyRandomArray.generateRandomArray(10, 10);
        Arrays.sort(randomArray);
        int mid = (randomArray.length - 1) / 2;
        if ((randomArray.length & 1) == 0) {
            System.out.println((randomArray[mid] + randomArray[mid + 1]) / 2);
        } else {
            System.out.println(randomArray[mid]);
        }

        MedianHolder medianHolder = new MedianHolder();
        for (int i = 0; i != randomArray.length; i++) {
            medianHolder.addNumber(randomArray[i]);
        }
        System.out.println(medianHolder.getMedian());
    }

}
