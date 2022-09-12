public class FindTargetSumWays {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        int res = findTargetSumWays(nums, target);
        System.out.println(res);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        if(target < 0)target = -target;
        int sum = 0;
        for (Integer i : nums) {
            sum += i;
        }
        int cap = sum + target;
        if (cap % 2 != 0){
            return 0;
        }
        cap /=2;
        int m = nums.length;
        int[][] dp =new int[m + 1][cap + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = cap; j >= 0 ; j--) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][cap];
    }
}
