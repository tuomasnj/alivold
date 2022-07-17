public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 1;
        System.out.println("一共有" + findTargetSumWays(nums, target) + "种方法让目标和等于" + target);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int size;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        } else {
            size = (sum + target) / 2;
        }
        if(size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] =1;
        //dp[j]表示容量为 j 的背包有多少种装满的方式
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j - nums[i] >= 0; j--) {
                dp[j] += dp[j- nums[i]];
            }
        }
        return dp[size];
    }
}
