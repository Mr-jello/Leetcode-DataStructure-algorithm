package top.mrjello.algorithm.d3_BinaryTree;

/**
 * @author jason@mrjello.top
 * @date 2023/7/22 20:50
 */
public class PaperFolding {

    /**
     * 请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折一次，压出折痕后展开。
     * 此时折痕是凹下去的，即折痕突起的方向指向纸条的背面。
     * 如果从纸条的下边向上方连续对折两次，压出折痕后展开，
     * 此时有三条折痕，从上到下依次是凹折痕、凹折痕和凸折痕。
     * 给定一个输入参数N，代表纸条都从下边向上方连续对折N次，
     * 请从上到下打印所有折痕的方向。
     * 例如：N=1时，打印：down
     * N=2时，打印：down down up
     * N=3时，打印：down down up down down up up
     * @param n 折叠次数
     */
    public static void printAllFolds(int n) {
        printProcess(1, n, true);
    }

    /**
     * 递归函数
     * @param i 节点当前层数
     * @param n 总层数
     * @param down true:凹折痕 false:凸折痕
     */
    public static void printProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printProcess(i + 1, n, true);
        System.out.println(down ? "down" : "up");
        printProcess(i + 1, n, false);
    }
}
