package top.mrjello.algorithm.d6_ForceRecursion;

import org.junit.jupiter.api.Test;

/**
 * @author jason@mrjello.top
 * @date 2023/7/28 18:30
 */
public class PrintAllSubsequences {

    /**
     * 打印一个字符串的全部子序列, 包括空字符串
     * @param str 字符串
     */
    public static void printAllSubsequence(String str) {
        // 将字符串转换为字符数组
        char[] chs = str.toCharArray();
        // 从第0个位置开始递归
        process(chs, 0);
    }

    /**
     * 递归函数
     * @param chs 字符数组
     * @param i 当前来到的位置
     */
    private static void process(char[] chs, int i) {
        // 如果当前来到的位置等于字符数组的长度, 说明已经来到了最后一个位置, 直接打印
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        //新增下一个字符进入考虑范围，并把之前的字符串也考虑进去
        process(chs, i + 1);
        char tmp = chs[i];
        chs[i] = ' ';
        // 不新增下一个字符进入考虑范围，只把之前的字符串考虑进去
        process(chs, i + 1);
        chs[i] = tmp;
    }







    @Test
    public void test() {
        printAllSubsequence("abc");
    }
}
