public class _offer14 {
    public static void main(String[] args) {
        int num=10;
        System.out.println(cuttingRope(num));
    }
    public static int cuttingRope(int n) {
        if(n<=3){return n-1;}
        int[] dp=new int[n+2];
        dp[1]=1;
        for (int i = 2; i <=n+1; i++) {
            for (int j = 1; j < i ; j++) {
                dp[i]=Math.max(dp[i-j]*j,dp[i]);
            }
        }
        return dp[n+1];
    }
}
