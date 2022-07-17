public class _63 {
    public static void main(String[] args) {
        int[] prices=new int[]{7,6,4,3,1};
        int res = maxProfit(prices);
        System.out.println(res);
    }
    public static int maxProfit(int[] prices) {
        if(prices.length<=1)return 0;
        int[] dp=new int[prices.length+1];

        //dp[n]表示第n天之前(包括n)卖出可以获得的最大收益
        dp[0]=0;dp[1]=0;
        int minIn=prices[0];
        for (int i = 2; i <= prices.length; i++) {
            dp[i]=Math.max(dp[i-1],prices[i-1]-minIn);
            minIn=Math.min(minIn,prices[i-1]);
        }
        return dp[dp.length-1];
    }
}
