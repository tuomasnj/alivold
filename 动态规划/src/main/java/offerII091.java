public class offerII091 {
    /**
     * 粉刷房子的最小成本
     * @param args
     */
    public static void main(String[] args) {
        int[][] cost = new int[][]{{17,2,17},{16,16,5},{14,3,19}};
        int minCost = minCost(cost);
        System.out.println(minCost);
    }

    /**
     * 刷房子的最小花费有三种情况
     * 因为最后一个房子可能有三个粉刷选项
     * 红色、蓝色、绿色
     * 所以有三个dp方程，从中选最小值即可
     * @param costs
     * @return
     */
    public static int minCost(int[][] costs){
        //dp[n][i]表示第n间房子刷第i种颜色的最低花费
        int n = costs.length;
        int[][] dp = new int[n+1][3];
        dp[1][0]= costs[0][0];
        dp[1][1]= costs[0][1];
        dp[1][2]= costs[0][2];
        for (int i = 2; i <=n ; i++) {
            dp[i][0] = Math.min(dp[i-1][1] + costs[i-1][0], dp[i-1][2] + costs[i-1][0]);
            dp[i][1] = Math.min(dp[i-1][0] + costs[i-1][1], dp[i-1][2] + costs[i-1][1]);
            dp[i][2] = Math.min(dp[i-1][0] + costs[i-1][2], dp[i-1][1] + costs[i-1][2]);
        }
        return Math.min(Math.min(dp[n][0],dp[n][1]),dp[n][2]);
    }
}
