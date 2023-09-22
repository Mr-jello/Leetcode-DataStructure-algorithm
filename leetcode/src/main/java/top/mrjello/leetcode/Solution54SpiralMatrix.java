package top.mrjello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
Given an m x n matrix, return all elements of the matrix in spiral order.


 Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


 Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]



 Constraints:


 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 10
 -100 <= matrix[i][j] <= 100


 Related Topics Array Matrix Simulation 👍 13497 👎 1173

*/

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution54SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        if (m == 0 || n == 0) {
            return res;
        }
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while (left <= right && top <= bottom) {
            // left to right
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            // right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
