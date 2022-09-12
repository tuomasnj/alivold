public class MaxProfitIII {
    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfitIII(prices));
    }

    public static int maxProfitIII(int[] prices) {
        //要增加一个标记最多购买多少次的维度k
        int len = prices.length;
        int maxK = 2;
        int[][][] dp =new int[len][maxK + 1][2];
        //dp[n][k][0]表示第n + 1天(此时股票交易的上限为k)买了股票剩余的最多现金
        //dp[n][k][1]表示第n + 1天(此时股票交易的上限为k)没买股票剩余的最多现金
        for (int i = 0; i < len; i++) {
            for (int k = 1; k <= maxK ; k++) {
                if (i == 0){
                    dp[i][k][0] = -prices[i];
                    dp[i][k][1] = 0;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k - 1][1] - prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k][0] + prices[i]);
            }
        }
        return dp[len - 1][maxK][1];
    }
}
