
public class _10 {
    public static void main(String[] args) {
        System.out.println(fib(15));
    }
    public static int fib(int n){
        if(n==0) return 0;
        int[] dp=new int[n+1];
        System.out.println(dp.length);
        dp[0]=0;dp[1]=1;
        for (int i = 2; i <=n ; i++) {
            dp[i]=(int)((dp[i-2]+dp[i-1])%(Math.pow(10,9)+7));
        }
        return dp[n];
    }
}
