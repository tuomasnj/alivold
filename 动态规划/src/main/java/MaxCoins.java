public class MaxCoins {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.println(maxCoins(nums));
    }

    //函数要返回的值是dp[0][m - 1]
    //所以i要从下向上递推，最后可以递推到 0
    //j则要从左往右递推，最后可以递推到 m - 1
    public static int maxCoins(int[] nums){
        int[] balloon = new int[nums.length + 2];
        balloon[0] = 1;balloon[balloon.length - 1] = 1;
        for (int i = 1; i < balloon.length - 1; i++) {
            balloon[i] = nums[i - 1];
        }
        int m = balloon.length;
        int[][] dp =new int[m][m];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + balloon[i]*balloon[k]*balloon[j]);
                }
            }
        }
        return dp[0][m -1];
    }
}
