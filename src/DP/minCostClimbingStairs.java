package DP;

/**
 * title 746.使用最小
 *
 */
public class minCostClimbingStairs {
    public int minCostClimbingStairs1(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < n; i++) {
            //状态转移方程
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
