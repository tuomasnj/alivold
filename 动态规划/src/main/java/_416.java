/**
 * 分割等和子集
 */
public class _416 {
    public static void main(String[] args) {
        int[] nums = {100};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        int max=0;
        for (int i : nums) {
            sum += i;
            max = Math.max(i,max);
        }
        int target = sum / 2;
        if (sum % 2 != 0 || max>target) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][target + 1];//dp表示前i个数字是否可以组合成一个和，其值等于target
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]]=true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j >=nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
