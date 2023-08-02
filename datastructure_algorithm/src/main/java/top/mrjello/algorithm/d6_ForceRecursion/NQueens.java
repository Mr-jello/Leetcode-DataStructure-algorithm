package top.mrjello.algorithm.d6_ForceRecursion;

import org.junit.jupiter.api.Test;

/**
 * @author jason@mrjello.top
 * @date 2023/7/27 20:55
 */
public class NQueens {

    /**
     * n皇后问题: 在n*n的棋盘上放置n个皇后, 任何两个皇后不能在同一行, 同一列, 也不能在同一斜线上
     * 方法一: 暴力递归
     * 限制条件: n不能大于32, 因为int类型的最大值为2^32-1
     *         n大于14时, 时间复杂度过高, 会超时
     * @param n 棋盘大小
     * @return 一共有多少种方法
     */
    public static int nQueens(int n) {
        if (n < 1) {
            return 0;
        }
        // record[i] = j 表示第i行的皇后放在了第j列
        int[] record = new int[n];
        // 从第0行开始放置皇后
        return process(0, record, n);
    }

    /**
     * 递归函数
     * @param i 当前来到的行数
     * @param record 记录数组
     * @param n 棋盘大小(总共有多少行)
     * @return  一共有多少种方法
     */
    public static int process(int i, int[] record, int n) {
        if (i == n) {
            // 如果当前来到的行数等于棋盘大小, 说明已经放置完毕, 返回1
            return 1;
        }
        // res: 一共有多少种方法
        int res = 0;
        // j: 当前来到的列数
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                // 如果当前位置合法, 将当前位置记录到record数组中, 并且递归下一行
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    /**
     * 判断当前位置是否合法
     * @param record 记录数组
     * @param i 当前来到的行数
     * @param j 当前来到的列数
     * @return 是否合法
     */
    public static boolean isValid(int[] record, int i, int j) {
        // k: 从第0行开始遍历到当前行
        for (int k = 0; k < i; k++) {
            //当前列已经有皇后
            if (j == record[k]
                    // 当前位置与之前的皇后在同一斜线上：两个皇后的行数之差等于列数之差
                || Math.abs(record[k] - j) == Math.abs(i - k)
            ) {
                return false;
            }
        }
        return true;
    }


    /**
     * 方法二: 位运算
     * 适用范围: n不能大于32, 因为int类型的最大值为2^32-1
     *         n超过32时，将int类型换成long类型
     * @param n 棋盘大小
     * @return 一共有多少种方法
     */
    public static int nQueensOptimize(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        // upperLim: 用来限制递归的上限
        // 用于生成一个后n位为1的二进制数, 例如n=4时, upperLim=1111
        int upperLim = n == 32 ? -1 : (1 << n) - 1;
        // 从第0行开始放置皇后
        return processOptimize(upperLim, 0, 0, 0);
    }

    /**
     * 递归函数
     * @param upperLim 限制递归的上限
     * @param colLim 列限制
     * @param leftDiaLim 左斜线限制
     * @param rightDiaLim 右斜线限制
     * @return 一共有多少种方法
     */
    public static int processOptimize(int upperLim, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == upperLim) {
            // 如果列限制与上限相等, 说明已经放置完毕, 返回1
            return 1;
        }
        // pos: 当前行可以放置皇后的位置
        int pos = 0;
        // mostRightOne: 当前行可以放置皇后的位置中最右边的1
        int mostRightOne = 0;
        // 1. 三种限制的并集, 用于生成当前行可以放置皇后的位置
        // 2. 限制的并集取反, 用于生成当前行可以放置皇后的位置中最右边的1
        // 3. 与上限取与, 用于生成当前行可以放置皇后的位置
        // 至此 1表示可以放置皇后, 0表示不可以放置皇后
        pos = upperLim & (~(colLim | leftDiaLim | rightDiaLim));
        int res = 0;
        // 当前行可以放置皇后的位置不为0时, 进行递归
        while (pos != 0) {
            // 生成当前行可以放置皇后的位置中最右边的1
            mostRightOne = pos & (~pos + 1);
            // 生成当前行可以放置皇后的位置中最右边的1之后, 将该位置置为0
            pos = pos - mostRightOne;
            // 递归下一行
            res += processOptimize(upperLim,
                            colLim | mostRightOne,
                         (leftDiaLim | mostRightOne) << 1,
                        (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }


    @Test
    public void test() {
        int n = 14;

        long start = System.currentTimeMillis();
        System.out.println(nQueens(n));
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(nQueensOptimize(n));
        end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - start) + "ms");
    }





}
