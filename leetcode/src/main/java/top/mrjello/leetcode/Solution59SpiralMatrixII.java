package top.mrjello.leetcode;

/**
Given a positive integer n, generate an n x n matrix filled with elements from 1
 to n² in spiral order.


 Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]


 Example 2:


Input: n = 1
Output: [[1]]



 Constraints:


 1 <= n <= 20


 Related Topics Array Matrix Simulation 👍 6018 👎 240

*/

//leetcode submit region begin(Prohibit modification and deletion)
public class Solution59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1, num = 1;
        while (left <= right && top <= bottom) {
            // left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = num++;
            }
            top++;
            // top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            // right to left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;
            // bottom to top
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
