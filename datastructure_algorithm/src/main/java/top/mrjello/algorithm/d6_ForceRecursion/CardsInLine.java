package top.mrjello.algorithm.d6_ForceRecursion;

import org.junit.jupiter.api.Test;

/**
 * @author jason@mrjello.top
 * @date 2023/8/1 16:36
 */
public class CardsInLine {

    /**
     * 给定一个整形数组arr，代表数值不同的纸牌排成一条线。
     * 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，
     * 但是每个玩家每次只能拿走最左或最右的纸牌
     * 玩家A和玩家B都绝顶聪明，返回最后获胜者的分数
     * @param arr 纸牌数组
     * @return 返回最后获胜者的分数
     */
    public static int winner(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //返回两个玩家的最大值
        return Math.max(firstPlayer(arr, 0, arr.length - 1), secondPlayer(arr, 0, arr.length - 1));
    }

    /**
     * 先手玩家
     * i代表左边一位，j代表右边一位
     * @param arr 纸牌数组
     * @param i 左边一位
     * @param j 右边一位
     * @return 返回两个玩家的最大值
     */
    public static int firstPlayer(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        //返回(i的位数的值 + i的后一位到第j位的最小值) 和 (j的位数的值 + i位到j的前一位的最小值) 的最大值
        return Math.max(arr[i] + secondPlayer(arr, i + 1, j), arr[j] + secondPlayer(arr, i, j - 1));
    }

    /**
     * 后手玩家
     * i代表左边一位，j代表右边一位
     * @param arr 纸牌数组
     * @param i 左边一位
     * @param j 右边一位
     * @return 返回两个玩家的最小值
     */
    public static int secondPlayer(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        //返回	(i的后一位到第j位的最大值) 和 (i位到j的前一位的最大值) 的最小值
        return Math.min(firstPlayer(arr, i + 1, j), firstPlayer(arr, i, j - 1));
    }


    public static int winnerUseDp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i + 1][j], arr[j] + s[i][j - 1]);
                s[i][j] = Math.min(f[i + 1][j], f[i][j - 1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }



    @Test
    public void test() {
        int[] arr = {1, 2, 100, 4};
        System.out.println(winner(arr));
    }
}
