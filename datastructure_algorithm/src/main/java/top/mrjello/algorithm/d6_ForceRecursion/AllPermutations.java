package top.mrjello.algorithm.d6_ForceRecursion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @author jason@mrjello.top
 * @date 2023/7/31 23:54
 */
public class AllPermutations {
    /**
     * 字符串的全排列
     * 分支限界法：
     * @param str 输入字符串
     * @return 全排列结果
     */
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();
        process(chars, 0, res);
        res.sort(null);
        return res;
    }


    /**
     * 递归函数
     * @param chars 字符数组
     * @param i 位置i
     * @param res 结果集
     */
    public static void process(char[] chars, int i, ArrayList<String> res) {
        // 递归终止条件
        if (i == chars.length) {
            res.add(String.valueOf(chars));
        }
        // 用于记录已经尝试过的字符
//        boolean[] visit = new boolean[26];
        // 从i开始遍历
        for (int j = i; j < chars.length; j++) {
            //如果chs[j]不为a，意思是如果已经尝试过a进行位置置换，则下次遇到就不尝试了
//            if (!visit[chars[j] - 'a']) {
//
//                visit[chars[j] - 'a'] = true;
                //交换字符串实现后续process，随后交换回来
                swap(chars, i, j);
                //递归调用
                process(chars, i + 1, res);
                //交换回来
                swap(chars, i, j);
//            }
        }
    }

    /**
     * 交换字符数组中两个字符的位置
     * @param chars 字符数组
     * @param i 位置i
     * @param j 位置j
     */
    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }


    @Test
    public void test() {
        String str = "abc";
        ArrayList<String> res = Permutation(str);
        System.out.println(res);
    }

}




