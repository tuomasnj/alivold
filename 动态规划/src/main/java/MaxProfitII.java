public class MaxProfitII {
    public static void main(String[] args) {
        int[] prices =new int[]{1, 2, 3, 4, 5};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices){
        int len = prices.length;
        int[][] dp =new int[len + 1][2];
        //dp[n][0]表示第n天买了股票剩余的最多现金
        //dp[n][1]表示第n天没买股票剩余的最多现金
        dp[1][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 2; i < len + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i -1]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i - 1], dp[i - 1][1]);
        }
        return dp[len][1];
    }
}
