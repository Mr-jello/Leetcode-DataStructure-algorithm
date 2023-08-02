package top.mrjello.algorithm.d6_ForceRecursion;

/**
 * @author jason@mrjello.top
 * @date 2023/7/28 17:56
 */
public class Hanoi {

    /**
     * 汉诺塔问题：
     *         1. 1 - (i - 1)，从from移动到other
     *         2. i, 从from移动到to
     *         3. 1 - (i - 1)，从other移动到to
     * @param n 圆盘数量
     */
    public static void hanoi(int n) {
        // 整体来看，是将所有圆盘从左边移动到右边
        if (n > 0) {
            func(n, "left", "right", "mid");
        }
    }

    /**
     * 1~i 圆盘 目标是from -> to,other是另外一个
     * @param i 圆盘数量
     * @param start 开始位置
     * @param end 结束位置
     * @param other 中间位置
     */
    public static void func(int i, String start, String end, String other){
        // 只有一个圆盘时，直接移动
        if (i == 1) {
            System.out.println("move 1 from " + start + " to " + end);
        }else {
            // 1 - (i - 1)，从from移动到other
            func(i - 1, start, other, end);
            // i, 从from移动到to
            System.out.println("move " + i + " from " + start + " to " + end);
            // 1 - (i - 1)，从other移动到to
            func(i - 1, other, end, start);
        }


    }

}
