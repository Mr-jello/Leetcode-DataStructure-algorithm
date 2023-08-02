package top.mrjello.leetcode;

import java.util.PriorityQueue;

/**
The median is the middle value in an ordered integer list. If the size of the
list is even, there is no middle value, and the median is the mean of the two
middle values.


 For example, for arr = [2,3,4], the median is 3.
 For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.


 Implement the MedianFinder class:


 MedianFinder() initializes the MedianFinder object.
 void addNum(int num) adds the integer num from the data stream to the data
structure.
 double findMedian() returns the median of all elements so far. Answers within 1
0⁻⁵ of the actual answer will be accepted.



 Example 1:


Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0



 Constraints:


 -10⁵ <= num <= 10⁵
 There will be at least one element in the data structure before calling
findMedian.
 At most 5 * 10⁴ calls will be made to addNum and findMedian.



 Follow up:


 If all integer numbers from the stream are in the range [0, 100], how would
you optimize your solution?
 If 99% of all integer numbers from the stream are in the range [0, 100], how
would you optimize your solution?


 Related Topics Two Pointers Design Sorting Heap (Priority Queue) Data Stream 👍
 10749 👎 210
 * @author Jason

 */

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution295FindMedianFromDataStream {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public Solution295FindMedianFromDataStream() {
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        modifyTwoHeapsSize();
    }

    public void modifyTwoHeapsSize() {
        if (this.maxHeap.size() == this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if (this.minHeap.size() == this.maxHeap.size() + 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public double findMedian() {

        int maxHeapSize = this.maxHeap.size();
        int minHeapSize = this.minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return 0.0;
        }
        if (maxHeapSize == 0 || minHeapSize == 0) {
            return maxHeapSize == 0 ? minHeap.peek().doubleValue() : maxHeap.peek().doubleValue();
        }
        Double maxHeapHead = maxHeap.peek().doubleValue();
        Double minHeapHead = minHeap.peek().doubleValue();
        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return (maxHeapHead + minHeapHead) / 2;
        }
        return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
    }

}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 * 执行耗时:120 ms,击败了84.44% 的Java用户
 * 内存消耗:59.7 MB,击败了99.63% 的Java用户
 */
//leetcode submit region end(Prohibit modification and deletion)
