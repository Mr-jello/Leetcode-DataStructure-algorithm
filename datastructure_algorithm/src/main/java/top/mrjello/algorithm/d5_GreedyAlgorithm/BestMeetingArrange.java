package top.mrjello.algorithm.d5_GreedyAlgorithm;

import java.util.Arrays;

/**
 * @author jason@mrjello.top
 * @date 2023/7/24 20:31
 */
public class BestMeetingArrange {

    /**
     * 贪心策略安排最佳会议时间问题
     *
     */
    public static class Program {
        //会议开始时间
        public int start;
        //会议结束时间
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 比较器，比较两场会议的结束时间差
     * 安排会议的时候，只要时间点<=某个会议的开始时间，就可以安排该会议
     * @param programs 会议数组
     * @param timePoint 时间点
     * @return 最多安排的会议数量
     */
    public static int bestMeetingArrange(Program[] programs, int timePoint) {
        //将所有会议按照会议结束时间进行排序
        Arrays.sort(programs, (o1, o2) -> o1.end - o2.end);
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            //只有时间点<=某个会议的开始时间，就安排该会议
            if (timePoint <= programs[i].start) {
                result++;
                //更新时间点
                timePoint = programs[i].end;
            }
        }
        return result;
    }
}
