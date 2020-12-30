package Tanxin;

import java.util.Arrays;

/**
 *
 * @title 452. 用最少数量的箭引爆气球
 *
 * @贪心算法之区间调度问题
 *
 *
 *
 */
public class findMinArrowShots {
    public int findMinArrowShots1(int[][] intvs) {
        if (intvs.length == 0) return 0;
        //按每个区间的end进行排序
        Arrays.sort(intvs,(p1, p2)->p1[1]<p2[1]?-1:1);
        int count = 1;
        int x_end = intvs[0][1];
        //删除与最先结束的区间x相交的区间
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start > x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
