public class Change02 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(change(amount , coins));
    }
    public static int change(int amount, int[] coins){
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length ; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                  dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
