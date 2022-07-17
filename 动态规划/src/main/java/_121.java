public class _121 {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        //dp[i][0] 表示第i天不持有股票拥有的现金
        //dp[i][1] 表示第i天持有股票拥有的现金
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(-prices[i],dp[i-1][1]);
        }
        return dp[len-1][0];
    }
}
