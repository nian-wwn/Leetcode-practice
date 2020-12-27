package DP;

/**
 * @title 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class uniquePaths {
    //方法一 动态规划
    // 找状态转换式
    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];

    }

    //方法二

    /**
     * 组合数学
     * 从左上角移到右上角，总共移动m+n-2次，向下m-1，向右n-1.
     * 就是从m+n-2中找到m-1次向下移动的方案数
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int)ans;

    }
}
