public class _10ii {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(numWays(n));
    }

    public static int numWays(int n) {
        if(n<=1)return 1;
        final int mode = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])% mode;
        }
        return dp[n] ;
    }
}
