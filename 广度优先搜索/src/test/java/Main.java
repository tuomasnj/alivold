import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] nums) {
        int maxLen = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i< nums.length; i++)
            for(int j = 0;j <= i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        maxLen = Math.max(maxLen, dp[i]);
                    }else{
                        continue;
                    }
                }
            }
        return maxLen;
    }
}
