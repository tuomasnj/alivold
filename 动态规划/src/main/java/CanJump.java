public class CanJump {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= i) {
                dp[i] = Math.max(dp[i - 1], i + nums[i]);
            }
        }
        return dp[len - 1] >= len - 1? true: false;
    }
}
