package top.mrjello.algorithm.d5_GreedyAlgorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author jason@mrjello.top
 * @date 2023/7/24 21:17
 */
public class LowestLexicography {

    /**
     * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所有字符串拼起来之后形成的字符串具有最小的字典序。
     * 字典序：从a-z的根据字段多少的排列
     */
    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //根据比较器的策略排序
        Arrays.sort(strs, (a, b) -> (a + b).compareTo(b + a));
        String res = "";
        //排序后依次拼接
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }


    @Test
    public void test() {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));
    }

}
