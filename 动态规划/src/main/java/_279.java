import java.util.Arrays;

public class _279 {
    public static void main(String[] args) {
        System.out.println(numSquare(10));
    }
    public static int numSquare(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j * j<= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
