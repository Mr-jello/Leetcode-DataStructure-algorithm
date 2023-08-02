package top.mrjello.algorithm.d6_ForceRecursion;

import org.junit.jupiter.api.Test;

/**
 * @author jason@mrjello.top
 * @date 2023/8/1 18:14
 */
public class Knapsack {
    /**
     * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表i号物品的重量和价值
     * 给定一个正数bag，表示一个载重bag的袋子，你装的物品不能超过这个重量
     * 返回你能装下最多的价值是多少？
     * @param weights 重量数组
     * @param values 价值数组
     * @param bag 背包的容量
     * @return 能装下的最大价值
     */
    public static int maxValue(int[] weights, int[] values, int bag) {

        return processLessParams(weights, values, 0, 0, bag);
//        return process(weights, values, 0, 0,0, bag);
    }

    /**
     * 递归函数更少的参数
     * @param weights 重量数组
     * @param values 价值数组
     * @param i 当前货物的下标
     * @param alreadyWeight 已经装的重量
     * @param bag 背包的容量
     * @return 能装下的最大价值
     */
    private static int processLessParams(int[] weights, int[] values, int i, int alreadyWeight, int bag) {
        // 当已装的重量超过bag，即超重了，则返回-values[i - 1]
        if (alreadyWeight > bag) {
            // 这里返回负数，是为了在递归的时候，不要当前i的货物
            return -values[i - 1];
        }
        // 当i已经超过重量表的长度，意味着都装不下
        if (i == weights.length) {
            return 0;
        }
        return Math.max(
                // 递归判断i+1的情况
                // 不要当前i的货物
                processLessParams(weights, values, i + 1, alreadyWeight, bag),
                //要当前i的货物
                values[i] + processLessParams(weights, values, i + 1, alreadyWeight + weights[i], bag));
    }

    /**
     * 递归函数 传入更多的参数
     * @param weights 重量数组
     * @param values 价值数组
     * @param i 当前货物的下标
     * @param alreadyWeight 已经装的重量
     * @param alreadyValue 已经装的价值
     * @param bag 背包的容量
     * @return 能装下的最大价值
     */
    public static int process(int[] weights, int[] values,
                              int i, int alreadyWeight, int alreadyValue, int bag) {
        // 当已装的重量超过bag，即超重了，则返回0
        if (alreadyWeight > bag) {
            return 0;
        }
        // 当i已经超过重量表的长度，意味着都装不下
        if (i == weights.length) {
            return alreadyValue;
        }
        return Math.max(
                // 递归判断i+1的情况
                // 不要当前i的货物
                process(weights, values, i + 1, alreadyWeight, alreadyValue, bag),
                //要当前i的货物
                process(weights, values, i + 1, alreadyWeight + weights[i], alreadyValue + values[i], bag));
    }

    /**
     * 动态规划
     * @param c 重量数组
     * @param p 价值数组
     * @param bag 背包的容量
     * @return 能装下的最大价值
     */
    public static int maxValueUseDp(int[] c, int[] p, int bag) {
        int[][] dp = new int[c.length + 1][bag + 1];
        for (int i = c.length - 1; i >= 0; i--) {
            for (int j = bag; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + c[i] <= bag) {
                    dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
                }
            }
        }
        return dp[0][0];
    }


    @Test
    public void test() {
        int[] weights = {3, 1, 4, 7, 2, 9};
        int[] values = {5, 6, 3, 19, 12, 4};
        int bag = 11;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(maxValueUseDp(weights, values, bag));
    }






}
