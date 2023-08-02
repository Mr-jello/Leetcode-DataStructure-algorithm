package top.mrjello.algorithm.d6_ForceRecursion;

/**
 * @author jason@mrjello.top
 * @date 2023/8/1 17:40
 */
public class ConvertToLetterString {

    /**
     * 规定1和A对应、2和B对应、3和C对应... 那么一个数字字符串比如"111"，就可以转化为"AAA"、"KA"和"AK"
     * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
     * @param str 数字字符串
     * @return 转化结果
     */
    public static int number(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    /**
     * 递归函数
     * 特殊情况1：如果存在0的位数，0是不能单独转换的，只有10和20的情况
     * 特殊情况2：如果存在某位3-9的范围中，那么也单独转换，因为不存在大于26的组合位数
     * @param str 数字字符串
     * @param i 当前位置
     * @return 转化结果
     */
    private static int process(char[] str, int i) {
        //如果i已经抵达最后位置，那么仅返回一种有效结果
        if (i == str.length) {
            return 1;
        }
        //如果存在0，由于之前的分配方法存在错误，所以返回0
        if (str[i] == '0') {
            return 0;
        }
        //如果某位上为1，res从i+1上持续递归
        if (str[i] == '1') {
            //i单独作为一个字母
            int res = process(str, i + 1);
            //如果i+1没有越界，res尝试并累加i+2上的数据
            //i和i+1作为一个字母
            if (i + 1 < str.length) {
                res += process(str, i + 2);
            }
            return res;
        }
        //如果某位上为2，res从i+1上持续递归
        if (str[i] == '2') {
            //i单独作为一个字母
            int res = process(str, i + 1);
            //但仅有在i+1没有越界时，
            //i和i+1作为一个字母
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += process(str, i + 2);
            }
            return res;
        }
        //如果某位上为3-9，res从i+1上持续递归
        return process(str, i + 1);
    }
}
