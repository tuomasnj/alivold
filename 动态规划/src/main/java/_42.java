public class _42 {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums){
        int[] dp=new int[nums.length+1];
        int max=Integer.MIN_VALUE;
        dp[0]=0;
        for (int i = 1; i <=nums.length ; i++) {
            dp[i]=Math.max(nums[i-1]+dp[i-1],nums[i-1]);
            max=dp[i]>max?dp[i]:max;
        }
        return max;
    }
}
