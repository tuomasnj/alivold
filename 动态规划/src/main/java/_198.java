public class _198 {
    public static void main(String[] args) {
        int[] money = {2,7,9,3,1};
        int rob = rob(money);
        System.out.println(rob);
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;dp[1] = nums[0];
        for (int i = 2; i <=n ; i++) {
            dp[i] = Math.max(dp[i-2] +nums[i-1],dp[i-1]);
        }
        return dp[n];
    }
}
