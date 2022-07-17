public class SumOfCombinations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        System.out.println("顺序不同的组合序列一共有"+ combinationSum4(nums, target)+"种");
    }
    public static int combinationSum4(int[] nums,int target){
        int[] dp =new int[target + 1];
        dp[0] =1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
